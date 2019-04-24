package com.softserve.dto;

import com.softserve.model.Author;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorDTO {
    private Integer id;
    private String firstName;
    private String lastName;

    public AuthorDTO(){}

    public AuthorDTO(Author author){
        id = author.getId();
        firstName = author.getFirstName();
        lastName = author.getLastName();
    }

    public Author getAuthor(){
        Author author = new Author();
        author.setId(id);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        return author;
    }
}
