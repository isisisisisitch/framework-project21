package ca.bytetube.dao;

import java.util.List;

public interface BaseDao<B, R> {
    boolean save(B bean);

    void find(R result);

    List<B> find();

    void count(R result);

    B find(Integer id);

    boolean remove(Integer id);

    boolean remove(List<Integer> ids);
}
