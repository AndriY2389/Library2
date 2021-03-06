package com.softserve.dao.impl;

import com.softserve.dao.generic.BookDAO;
import com.softserve.model.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAOimpl extends AbstractDAO<Book, Integer> implements BookDAO {

    public BookDAOimpl() {
        super(Book.class);
    }
}
