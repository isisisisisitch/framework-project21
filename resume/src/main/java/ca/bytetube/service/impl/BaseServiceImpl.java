package ca.bytetube.service.impl;

import ca.bytetube.bean.result.PageResult;
import ca.bytetube.dao.BaseDao;
import ca.bytetube.service.BaseService;

import java.util.List;

@SuppressWarnings("unchecked")
public abstract class BaseServiceImpl<B, R extends PageResult<B>> implements BaseService<B, R> {
    protected final BaseDao<B, R> dao = newDao();

    protected BaseDao<B, R> newDao() {
        String clsName = getClass().getName();
        clsName = clsName.replace(".service.", ".dao.");
        clsName = clsName.replace("Service", "Dao");
        try {
            return (BaseDao<B, R>) Class.forName(clsName).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean save(B bean) {
        return dao.save(bean);
    }

    @Override
    public void find(R result) {
        dao.count(result);
        int pages = result.getPages();
        if (result.getPageNo() > pages) {
            result.setPageNo(pages);
        }
        dao.find(result);
    }

    @Override
    public List<B> find() {
        return dao.find();
    }

    @Override
    public B find(Integer id) {
        return dao.find(id);
    }

    @Override
    public boolean remove(Integer id) {
        return dao.remove(id);
    }

    @Override
    public boolean remove(List<Integer> ids) {
        return dao.remove(ids);
    }
}
