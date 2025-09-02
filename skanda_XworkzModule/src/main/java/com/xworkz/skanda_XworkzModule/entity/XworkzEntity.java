package com.xworkz.skanda_XworkzModule.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="xworkz_table")
//@NamedQuery(name = "signInValidation",query = "Select entity.userPassword from XworkzEntity entity where entity.userEmail = :email")
@NamedQuery(name = "emailOPT",query = "Select entity from XworkzEntity entity where entity.userEmail=:email" )
@NamedQuery(name="otpSend",query = "select entity from XworkzEntity entity where entity.userEmail=:email ")
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

    @Column(name="adress")
    private String userAdress;

    @Column(name="gender")
    private String userGender;

    @Column(name="filed_attempts")
    private  int userFiledAttempts;


    @Column(name="time")
    private LocalDateTime LockTime;
}
