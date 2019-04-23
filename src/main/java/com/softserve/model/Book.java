package com.softserve.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="books")
public class Book {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Books_authors",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")}
    )
    private List<Author> authors;

    @Column(name = "RELEASE_DATE")
    @Temporal(value = TemporalType.DATE)
    private Date releaseDate;

    @Column(name = "AVAILABLE")
    private Boolean available;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="books")
    private List<Order> orders;


}
