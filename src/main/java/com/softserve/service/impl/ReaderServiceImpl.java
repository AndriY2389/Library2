package com.softserve.service.impl;

import com.softserve.dao.generic.ReaderDAO;
import com.softserve.model.Reader;
import com.softserve.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    ReaderDAO readerDAO;

    @Override
    @Transactional
    public boolean save(Reader entity) {
        readerDAO.save(entity);
        return true;
    }

    @Override
    @Transactional
    public boolean delete(Reader entity) {
        readerDAO.delete(entity);
        return true;
    }

    @Override
    public List<Reader> findAll() {
        return readerDAO.findAll();
    }

    @Override
    @Transactional
    public boolean update(Reader entity) {
        readerDAO.update(entity);
        return true;
    }

    @Override
    public Reader findById(Integer id) {
        return readerDAO.findById(id);
    }

    @Override
    @Transactional
    public boolean deleteById(Integer id) {
        readerDAO.deleteById(id);
        return true;
    }
}
