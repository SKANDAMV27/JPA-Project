package com.prapthi.CRUD_Many_To_Many.controller;

import com.prapthi.CRUD_Many_To_Many.dto.StudentDTO;
import com.prapthi.CRUD_Many_To_Many.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    public StudentDTO saveAll(StudentDTO studentDTO){
        System.out.println("Save Successfully");
        return studentService.save(studentDTO);
    }
}
