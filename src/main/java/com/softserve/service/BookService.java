package com.softserve.service;


import com.softserve.dto.BookDTO;
import com.softserve.model.Book;

import java.util.List;


public interface BookService {

    boolean save(Book entity);

    boolean delete(Book entity);

    List<Book> findAll();

    boolean update(BookDTO entity);

    Book findById(Integer id);

    boolean deleteById(Integer id);

}
