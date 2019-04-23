package com.softserve.service;


import com.softserve.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookService {

    void save(Book entity);

    void delete(Book entity);

    List<Book> findAll();

    void update(Book entity);

    Book findById(Integer id);

    void deleteById(Integer id);
}
