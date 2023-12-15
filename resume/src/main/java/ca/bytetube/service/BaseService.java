package ca.bytetube.service;

import java.util.List;

public interface BaseService<B, R> {
    boolean save(B bean);

    void find(R result);

    List<B> find();

    B find(Integer id);

    boolean remove(Integer id);

    boolean remove(List<Integer> ids);
}
