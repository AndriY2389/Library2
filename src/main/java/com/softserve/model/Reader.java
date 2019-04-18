package com.softserve.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="reader")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "AGE")
    private Integer age;
}
