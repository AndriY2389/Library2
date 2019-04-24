package com.softserve.dto;

import com.softserve.model.Reader;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReaderDTO {
    private Integer id;
    private String firstName;
    private String lastName;

    public ReaderDTO(){}

    public ReaderDTO(Reader reader){
        id = reader.getId();
        firstName = reader.getFirstName();
        lastName = reader.getLastName();
    }

    public Reader getReader(){
        Reader reader = new Reader();
        reader.setId(id);
        reader.setFirstName(firstName);
        reader.setLastName(lastName);
        return reader;
    }
}