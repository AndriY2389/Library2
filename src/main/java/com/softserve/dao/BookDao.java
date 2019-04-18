package com.softserve.dao;

import com.softserve.model.Book;

import java.util.List;

public interface BookDao {

    public List listAllBooks();

    public void saveOrUpdate(Book book);

    public Book findBookById(int id);

    public void deleteBook(int id);

}
