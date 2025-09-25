package com.prapthi.CRUD_Many_To_Many.controller;

import com.prapthi.CRUD_Many_To_Many.dto.StudentDTO;
import com.prapthi.CRUD_Many_To_Many.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public StudentDTO saveAll(@RequestBody StudentDTO studentDTO){
        System.out.println("Save Successfully");
        return studentService.save(studentDTO);
    }
}
