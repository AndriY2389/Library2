package com.softserve.service;

import com.softserve.model.Reader;

import java.util.List;

public interface ReaderService {

    void save(Reader entity);

    void delete(Reader entity);

    List<Reader> findAll();

    void update(Reader entity);

    Reader findById(Integer id);

    void deleteById(Integer id);
}
