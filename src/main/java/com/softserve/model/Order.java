package com.softserve.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name="orders")
public class Order {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID",nullable = false)
    private Book books;

    @Column(name = "DATE_OF_ISSUANCE")
    @Temporal(value = TemporalType.DATE)
    private Date dateOfIssuance;

    @Column(name = "DATE_OF_RETURN")
    @Temporal(value = TemporalType.DATE)
    private Date dateOfReturn;

    @ManyToOne
    @JoinColumn(name="READER_ID", nullable=false)
    private Reader readers;
}
