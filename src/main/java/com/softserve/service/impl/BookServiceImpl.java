package com.softserve.service.impl;

import com.softserve.dao.generic.BookDAO;
import com.softserve.model.Book;
import com.softserve.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDAO bookDAO;

    @Override
    @Transactional
    public boolean save(Book entity) {
        if(conditionCreate(entity)){
            bookDAO.save(entity);
            return true;
        } else {
            return false;
        }
    }

    private boolean conditionCreate(Book entity) {
        return !entity.getName().equals("") && !entity.getReleaseDate().equals("");
    }


    @Override
    @Transactional
    public boolean delete(Book entity) {
        bookDAO.delete(entity);
        return true;
    }

    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    @Transactional
    public boolean update(Book entity) {
        bookDAO.update(entity);
        return true;
    }

    @Override
    public Book findById(Integer id) {
        return bookDAO.findById(id);
    }

    @Override
    @Transactional
    public boolean deleteById(Integer id) {
        bookDAO.deleteById(id);
        return true;
    }
}
