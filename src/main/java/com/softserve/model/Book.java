package com.softserve.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String Name;

    @Column(name = "RELEASE_DATE")
    private Date releaseDate;

    @Column(name = "AVALIABLE")
    private Boolean avaliable;
}
