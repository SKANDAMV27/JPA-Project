package com.xworkz.skanda_XworkzModule.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name="xworkz_table")
public class XworkzEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String userName;

    @Column(name="number")
    private String phoneNumber;

    @Column(name="email")
    private String userEmail;

    @Column(name="age")
    private  int userAge;

    @Column(name="password")
    private String userPassword;
    @Transient
    private String conformPassword;

    @Column(name="adress")
    private String userAdress;
    @Column(name="gender")
    private String userGender;
}
