package com.softserve.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="authors")
public class Author {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author",cascade = CascadeType.REMOVE)
    private List<Book> books;

    @Column(name = "LAST_NAME")
    private String lastName;
}
