package com.softserve.dao;

import com.softserve.model.Reader;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class ReaderDaoImpl implements ReaderDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public List listAllReaders() {
        CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
        CriteriaQuery<Reader> criteriaQuery = criteriaBuilder.createQuery(Reader.class);
        return criteriaQuery.getOrderList();
    }

    @Override
    public void saveOrUpdate(Reader reader) {
        getSession().save(reader);
    }

    @Override
    public Reader findReaderById(int id) {
        return null;
    }

    @Override
    public void deleteReader(int id) {

    }
}
