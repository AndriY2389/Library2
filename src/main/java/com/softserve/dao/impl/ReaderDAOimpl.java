package com.softserve.dao.impl;

import com.softserve.dao.generic.ReaderDAO;
import com.softserve.model.Reader;
import org.springframework.stereotype.Repository;

@Repository
public class ReaderDAOimpl extends AbstractDAO<Reader,Integer> implements ReaderDAO {
    public ReaderDAOimpl() {
        super(Reader.class);
    }
}
