package com.softserve.service.impl;

import com.softserve.dao.generic.AuthorDAO;
import com.softserve.model.Author;
import com.softserve.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorDAO authorDAO;

    @Override
    public void save(Author entity) {
    }

    @Override
    public void delete(Author entity) {

    }

    @Override
    public List<Author> findAll() {
        return null;
    }

    @Override
    public void update(Author entity) {

    }

    @Override
    public Author findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
