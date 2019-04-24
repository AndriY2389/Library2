package com.softserve.service.impl;

import com.softserve.dao.generic.AuthorDAO;
import com.softserve.dto.AuthorDTO;
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
        AuthorDTO authorDTO = new AuthorDTO(entity);
        if (conditionCreate(entity) && isAuthorInputRigth(authorDTO)) {
            authorDAO.save(entity);
            return true;
        } else {
            return false;
        }
    }

    private boolean conditionCreate(Author entity) {
        boolean condition = true;
        if (entity.getFirstName().equals("") || entity.getLastName().equals("")) {
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

    @Override
    @Transactional
    public boolean update(Author entity) {
        AuthorDTO author = new AuthorDTO(findById(entity.getId()));
        if (entity.getFirstName().equals("") && entity.getLastName().equals("")) {
            return false;
        }
        if (!entity.getLastName().equals("")) {
            author.setLastName(entity.getLastName());
        }
        if (!entity.getFirstName().equals("")) {
            author.setFirstName(entity.getFirstName());
        }
        if (!isAuthorInputRigth(author)) {
            return false;
        }
        authorDAO.update(author.getAuthor());
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
    public boolean isAuthorInputRigth(AuthorDTO entity) {
        Pattern pattern = Pattern.compile("[A-Za-z]+[ -]?[A-Za-z]+");
        Matcher firstNameMatcher = pattern.matcher(entity.getFirstName());
        Matcher lastNameMatcher = pattern.matcher(entity.getLastName());
        return firstNameMatcher.matches() && lastNameMatcher.matches();
    }
}
