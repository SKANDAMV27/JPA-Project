package com.xworkz.save.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="save_table")
public class SaveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String userName;

    @Column(name="email")
    private String userEmail;

    @Column(name="phone_number")
    private String usreNumber;

    @Column(name = "age")
    private int userAge;
}
