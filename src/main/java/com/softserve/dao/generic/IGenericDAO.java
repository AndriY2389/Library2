package com.softserve.dao.generic;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGenericDAO<T, ID> {

    void save(T entity);

    void delete(T entity);

    List<T> findAll();

    void update(T entity);

    T findById(Integer id);

    void deleteById(Integer id);
}
