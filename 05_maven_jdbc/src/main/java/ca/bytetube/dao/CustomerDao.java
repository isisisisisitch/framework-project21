package ca.bytetube.dao;

import ca.bytetube.bean.Customer;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class CustomerDao {
    private static JdbcTemplate template;

    static {
        try {
            //获取连接池
            Properties properties = new Properties();

            properties.load(CustomerDao.class.getClassLoader().getResourceAsStream("druid.properties"));
            DataSource ds = DruidDataSourceFactory.createDataSource(properties);
            //创建template对象
            template = new JdbcTemplate(ds);
        } catch (Exception e) {
            e.printStackTrace();

        }


    }


    public List<Customer> list() {

        String sql = "SELECT id,name,age,height FROM customer";

        return template.query(sql, new BeanPropertyRowMapper<>(Customer.class));
    }

}
