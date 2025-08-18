package com.xworkz.skanda_XworkzModule.entity;

import javax.persistence.*;


@Entity
@Table(name="xworkz_table")
public class XworkzEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String userName;

    @Column(name="phone_number")
    private long phoneNumber;

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
