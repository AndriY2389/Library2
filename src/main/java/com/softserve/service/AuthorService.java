package com.softserve.service;

import com.softserve.model.Author;

import java.util.List;

public interface AuthorService {

    void save(Author entity);

    void delete(Author entity);

    List<Author> findAll();

    void update(Author entity);

    Author findById(Integer id);

    void deleteById(Integer id);
}
