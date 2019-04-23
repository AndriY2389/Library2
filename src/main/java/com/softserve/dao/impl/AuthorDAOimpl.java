package com.softserve.dao.impl;

import com.softserve.dao.generic.AuthorDAO;
import com.softserve.model.Author;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AuthorDAOimpl extends AbstractDAO<Author, Integer> implements AuthorDAO {
    public AuthorDAOimpl() {
        super(Author.class);
    }
}
