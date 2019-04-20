package com.softserve.service.impl;

import com.softserve.dao.generic.BookDAO;
import com.softserve.model.Book;
import com.softserve.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDAO bookDAO;

    @Override
    public void save(Book entity) {

    }

    @Override
    public void delete(Book entity) {

    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public void update(Book entity) {

    }

    @Override
    public Book findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
