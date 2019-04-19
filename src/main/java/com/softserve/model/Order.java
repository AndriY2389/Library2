package com.softserve.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ID_READER")
    private Integer id_reader;

    @Column(name = "ID_BOOK")
    private Integer id_book;

    @Column(name = "DATE_OF_ISSUANCE")
    @Temporal(value = TemporalType.DATE)
    private Date dateOfIssuance;

    @Column(name = "DATE_OF_RETURN")
    @Temporal(value = TemporalType.DATE)
    private Date dateOfReturn;

    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    private Reader reader;
}
