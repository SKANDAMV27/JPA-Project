package com.xworkz.save.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "save_table")
@NamedQueries({
        @NamedQuery(
                name = "getAll",
                query = "SELECT e FROM SaveEntity e"
        ),
        @NamedQuery(
                name = "removeByUserName",
                query = "DELETE FROM SaveEntity e WHERE e.userName = :userName"
        ),
        @NamedQuery(name="checkEmailAndNumber",
                query = "Select count Entity from SaveEntity Entity.userEmail=:email or Entity.userNumber = :number")
})
public class SaveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String userName;

    @Column(name = "email")
    private String userEmail;

    @Column(name = "phone_number")
    private String userNumber;

    @Column(name = "age")
    private int userAge;

    public SaveEntity() {
        System.out.println("Save Entity created");
    }
}
