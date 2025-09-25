package com.prapthi.CRUD_Many_To_Many.service;

import com.prapthi.CRUD_Many_To_Many.dto.StudentDTO;
import com.prapthi.CRUD_Many_To_Many.entity.StudentEntity;
import com.prapthi.CRUD_Many_To_Many.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


}
