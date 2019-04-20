package com.softserve.dao.impl;

import com.softserve.dao.generic.BookDAO;
import com.softserve.model.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class BookDAOimpl extends AbstractDAO<Book,Integer> implements BookDAO {

}
