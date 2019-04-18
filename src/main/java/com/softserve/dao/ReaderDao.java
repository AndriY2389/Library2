package com.softserve.dao;

import com.softserve.model.Reader;

import java.util.List;

public interface ReaderDao {

    public List listAllReaders();

    public void saveOrUpdate(Reader reader);

    public Reader findReaderById(int id);

    public void deleteReader(int id);

}
