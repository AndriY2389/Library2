package com.softserve.service.impl;

import com.softserve.dao.generic.AuthorDAO;
import com.softserve.model.Author;
import com.softserve.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorDAO authorDAO;

    @Transactional
    @Override
    public boolean save(Author entity) {
        if(conditionCreate(entity) && isAuthorInputRigth(entity)){
            authorDAO.save(entity);
            return true;
        } else {
            return false;
        }
    }

    private boolean conditionCreate(Author entity) {
        boolean condition = true;
        if(entity.getFirstName().equals("")||entity.getLastName().equals("")){
            condition = false;
        }
        return condition;
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

    @Override
    public boolean isAuthorInputRigth(Author entity) {
        Pattern pattern = Pattern.compile("[A-Za-z]+[ -]?[A-Za-z]+");
        Matcher firstNameMatcher = pattern.matcher(entity.getFirstName());
        Matcher lastNameMatcher = pattern.matcher(entity.getLastName());
        if (firstNameMatcher.matches() && lastNameMatcher.matches()) {
            return true;
        }
        return false;
    }
}
