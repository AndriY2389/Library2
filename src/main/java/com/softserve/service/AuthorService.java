package com.softserve.service;

import com.softserve.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AuthorService {

    boolean save(Author entity);

    boolean delete(Author entity);

    List<Author> findAll();

    boolean update(Author entity);

    Author findById(Integer id);

    boolean deleteById(Integer id);
}
