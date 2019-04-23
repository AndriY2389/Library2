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

    @Transactional
    @Override
    public boolean save(Author entity) {
        authorDAO.save(entity);
        return false;
    }

    @Transactional
    @Override
    public boolean delete(Author entity) {
        authorDAO.delete(entity);
        return true;
    }

    @Override
    public List<Author> findAll() {
        return authorDAO.findAll();
    }

    @Transactional
    @Override
    public boolean update(Author entity) {
        authorDAO.update(entity);
        return true;
    }

    @Override
    public Author findById(Integer id) {
        return authorDAO.findById(id);
    }

    @Transactional
    @Override
    public boolean deleteById(Integer id) {
        authorDAO.deleteById(id);
        return true;
    }

    @Override
    public Author findByName(String name) {
        String firstName = name.split(" ")[0];
        String lastName = name.split(" ")[1];
        List<Author> authorList = findAll();
        for (Author a : authorList) {
            if (a.getFirstName().equals(firstName) && a.getLastName().equals(lastName)) {
                return a;
            }
        }
        return null;
    }
}
