package com.softserve.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String Name;

    @ManyToMany(fetch = FetchType.LAZY,cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Books_authors",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")}
    )
    private List<Author> authors = new ArrayList<>();

    @Column(name = "RELEASE_DATE")
    @Temporal(value = TemporalType.DATE)
    private Date releaseDate;

    @Column(name = "AVAILABLE")
    private Boolean available;
}
