package com.prapthi.CRUD_OneToOne.service;

import com.prapthi.CRUD_OneToOne.repositry.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;



}
