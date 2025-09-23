package com.prapthi.CRUD_OneToOne.controller;

import com.prapthi.CRUD_OneToOne.dto.StudentDto;
import com.prapthi.CRUD_OneToOne.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/")
    public StudentDto saveAll(@RequestBody StudentDto studentDto){
        System.out.println("Data Will Save Successfully");
        return studentService.save(studentDto);
    }

    @GetMapping("/getAll")
    public List<StudentDto> getAllData(){
        System.out.println("Read All The Data");
        return studentService.getAll();
    }

}
