package com.xworkz.skanda_XworkzModule.entity;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="xworkz_table")
public class xworkzEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    @Size(max = 10,min = 3,message = "Name Should Max 10 and Min 3")
    private String userName;
    @Column(name="phone_number")
    @Pattern(regexp = "^(?:9876)[0-9]{6}$",message = "Phone Number Should Be 10 Digits and Start From 9876")
    private long phoneNumber;
    @Column(name="email")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}$",message = "Email Id Must cantain @xxx.xxx")
    private String userEmail;
    @Column(name="age")
    @Min(value = 15,message = "Age Should Be Min 15")
    @Max(value = 50,message = "Age Should Me Max 50")
    private  int userAge;
    @Pattern(regexp =  "^(?=.*[A-Z])(?=.*[!@#$%^&*])(?=(?:.*\\\\d){3,})(?=.{8,15}$)" +
            "        message = \"Password must be 8-15 chars, 1 uppercase, 1 special char, and at least 3 digits\"")
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
