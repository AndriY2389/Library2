package com.softserve.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="authors")
public class Author {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "authors")
    private List<Book> books;

    @Column(name = "LAST_NAME")
    private String lastName;
}
