package com.prapthi.CRUD_Many_To_Many.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String studentName;

    private String studentBranch;

    @ManyToMany
    @JoinTable(name="student_Course" //this is new table
            ,joinColumns = @JoinColumn(name="student_id",referencedColumnName = "id")//Parent Class Name
            ,inverseJoinColumns = @JoinColumn(name="course_id",referencedColumnName = "id"))//child class Name
    private List<CourseEntity> course;



}
