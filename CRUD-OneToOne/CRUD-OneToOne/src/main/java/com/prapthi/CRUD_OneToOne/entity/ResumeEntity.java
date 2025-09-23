package com.prapthi.CRUD_OneToOne.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String context;

    @OneToOne
    @JoinColumn(name="studentId", nullable = false)
    @JsonIgnore
    private StudentEntity student;
}
