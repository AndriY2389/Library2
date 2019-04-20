package com.softserve.service.impl;

import com.softserve.dao.generic.ReaderDAO;
import com.softserve.model.Reader;
import com.softserve.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    ReaderDAO readerDAO;

    @Override
    public void save(Reader entity) {

    }

    @Override
    public void delete(Reader entity) {

    }

    @Override
    public List<Reader> findAll() {
        return null;
    }

    @Override
    public void update(Reader entity) {

    }

    @Override
    public Reader findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
