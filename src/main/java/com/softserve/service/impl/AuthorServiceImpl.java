package com.softserve.service.impl;

import com.softserve.dao.generic.AuthorDAO;
import com.softserve.model.Author;
import com.softserve.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorDAO authorDAO;

    @Override
    @Transactional
    public boolean save(Author entity) {
        authorDAO.save(entity);
        return true;
    }

    @Override
    @Transactional
    public boolean delete(Author entity) {
        authorDAO.delete(entity);
        return true;
    }

    @Override
    public List<Author> findAll() {
        return authorDAO.findAll();
    }

    @Override
    @Transactional
    public boolean update(Author entity) {
        authorDAO.update(entity);
        return true;
    }

    @Override
    public Author findById(Integer id) {
        return authorDAO.findById(id);
    }

    @Override
    @Transactional
    public boolean deleteById(Integer id) {
        authorDAO.deleteById(id);
        return true;
    }
}
