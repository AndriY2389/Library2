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

    @Column(name = "ID_ID_BOOK")
    private Integer id_book;

    @Column(name = "DATE_OF_ISSUANCE")
    private Date dateOfIssuance;

    @Column(name = "DATE_OF_RETURN")
    private Date dateOfReturn;
}
