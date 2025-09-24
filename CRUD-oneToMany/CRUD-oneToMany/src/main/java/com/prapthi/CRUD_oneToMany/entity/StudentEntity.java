package com.prapthi.CRUD_oneToMany.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String studentName;
    private String studentSection;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private SchoolEntity school;
}
