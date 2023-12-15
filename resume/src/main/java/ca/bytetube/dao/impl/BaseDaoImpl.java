package ca.bytetube.dao.impl;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import ca.bytetube.bean.result.PageResult;
import ca.bytetube.beans.bean.SQLBean;
import ca.bytetube.beans.util.Beans;
import ca.bytetube.beans.util.Sqls;
import ca.bytetube.dao.BaseDao;
import ca.bytetube.util.Strings;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@SuppressWarnings({"unchecked"})
public abstract class BaseDaoImpl<B extends SQLBean, R extends PageResult<B>> implements BaseDao<B, R> {
    protected static JdbcTemplate tpl;
    static {
        try {
            Properties properties = new Properties();
            InputStream is = BaseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            tpl = new JdbcTemplate(DruidDataSourceFactory.createDataSource(properties));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected List<Object> buildArgs(StringBuilder sql,  R result) { return null; }
    private final Class<B> beanClass = (Class<B>) ((ParameterizedType) getClass().getGenericSuperclass())
            .getActualTypeArguments()[0];
    private final String table = Strings.underlineCased(beanClass.getSimpleName());

    @Override
    public boolean save(B bean) {
        List<Object> args = new ArrayList<>();
        return tpl.update(Sqls.buildSaveSQL(bean, args), args.toArray()) > 0;
    }

    @Override
    public void find(R result) {
        if (result == null) return;
        StringBuilder sql = new StringBuilder("SELECT * FROM ");
        sql.append(table);
        sql.append(" ");
        List<Object> args = buildArgs(sql, result);
        if (args == null) {
            args = new ArrayList<>();
        }

        sql.append(" ORDER BY id DESC LIMIT ?, ?");
        int pageSize = result.getPageSize();
        args.add((result.getPageNo() - 1) * pageSize);
        args.add(pageSize);

        try {
            List<B> beans = tpl.query(sql.toString(),
                    new BeanPropertyRowMapper<>(beanClass), args.toArray());
            result.setBeans(beans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<B> find() {
        return tpl.query(Sqls.buildFindSQL(beanClass) + " ORDER BY id DESC",
                (rs, i) -> Beans.convert(rs, beanClass));
    }

    @Override
    public void count(R result) {
        if (result == null) return;
        StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM ");
        sql.append(table);
        List<Object> args = buildArgs(sql, result);
        Integer count = tpl.queryForObject(sql.toString(), Integer.class, args.toArray());
        result.setCount(count);
    }


    @Override
    public B find(Integer id) {
        return tpl.queryForObject(Sqls.buildFindSingleSQL(beanClass),
                (rs, i) -> Beans.convert(rs, beanClass), id);
    }

    @Override
    public boolean remove(Integer id) {
        String sql = "DELETE FROM " + table + " WHERE id = ?";
        return tpl.update(sql, id) > 0;
    }

    @Override
    public boolean remove(List<Integer> ids) {
        StringBuilder sql = new StringBuilder("DELETE FROM " + table + " WHERE id IN (");
        for (Integer id : ids) {
            sql.append("?,");
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(")");
        return tpl.update(sql.toString(), ids.toArray()) > 0;
    }
}
