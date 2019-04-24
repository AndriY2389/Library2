package com.softserve.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="books")
public class Book {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinTable(name = "AUTHOR_ID")
    private Author author;

    @Column(name = "RELEASE_DATE")
    @Temporal(value = TemporalType.DATE)
    private Date releaseDate;

    @Column(name = "AVAILABLE")
    private Boolean available;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="books",cascade = {CascadeType.REMOVE})
    private List<Order> orders;

}
