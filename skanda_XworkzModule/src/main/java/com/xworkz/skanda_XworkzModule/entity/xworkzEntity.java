package com.xworkz.skanda_XworkzModule.entity;

import jakarta.validation.constraints.*;
import lombok.*;

import javax.persistence.*;


@Entity
@Table(name="xworkz_table")
public class xworkzEntity {
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

    @NotBlank(message = "Adress Should be Required")
    @Column(name="adress")
    private String userAdress;
    @Pattern(regexp = "m|f|o",message = "Should be Male(m),Female(f) or Other(o) ")
    @Column(name="gender")
    private String userGender;
}
