package com.softserve.dto;

import com.softserve.model.Author;
import com.softserve.model.Book;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class BookDTO {
    private Integer id;
    private String name;
    private Date releaseDate;
    private boolean available;
    private Author author = null;

    public BookDTO(){

    }

    public BookDTO(Book book){
        id = book.getId();
        name = book.getName();
        releaseDate = (Date) book.getReleaseDate();
        available = book.getAvailable();
        author = book.getAuthor();
    }

    public Book getBook(){
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setReleaseDate(releaseDate);
        book.setAvailable(available);
        book.setAuthor(author);
        return book;
    }


}
