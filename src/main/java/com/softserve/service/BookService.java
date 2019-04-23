package com.softserve.service;


import com.softserve.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookService {

    boolean save(Book entity);

    boolean delete(Book entity);

    List<Book> findAll();

    boolean update(Book entity);

    Book findById(Integer id);

    boolean deleteById(Integer id);
}
