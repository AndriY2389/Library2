package com.softserve.dao;

import com.softserve.model.Author;

import java.util.List;

public interface AuthorDao {

    public List listAllAuthors();

    public void saveOrUpdate(Author author);

    public Author findAuthorById(int id);

    public void deleteAuthor(int id);

}
