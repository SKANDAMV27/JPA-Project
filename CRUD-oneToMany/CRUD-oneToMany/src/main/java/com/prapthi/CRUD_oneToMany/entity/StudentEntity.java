package com.prapthi.CRUD_oneToMany.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String studentName;

    private char studentSection;

    @OneToMany
    @JoinColumn(name="schoolId",nullable = true)
    @JsonIgnore
    private StudentEntity studentEntity;

}
