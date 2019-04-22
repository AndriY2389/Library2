package com.softserve.dao.impl;

import com.softserve.dao.generic.IGenericDAO;
import com.softserve.model.Author;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public abstract class AbstractDAO<T,ID> implements IGenericDAO<T,ID> {

    private Class<T> clazz;

    @PersistenceContext
    EntityManager entityManager;

    public AbstractDAO(){

    }

    public AbstractDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void setClazz(Class<T> clazzToSet){
        this.clazz = clazzToSet;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void save(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public void delete(T entity) {
        entityManager.remove(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll() {
        return (List<T>) entityManager.createQuery("from " + clazz.getName()).getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void update(T entity) {
        entityManager.merge(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T findById(Integer id) {
        return entityManager.find(clazz,id);
    }

    @Override
    public void deleteById(Integer id) {
        T entity = findById(id);
        entityManager.remove(entity);
    }
}
