package com.prapthi.CRUD_Many_To_Many.controller;

import com.prapthi.CRUD_Many_To_Many.dto.CourseDTO;
import com.prapthi.CRUD_Many_To_Many.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/save")
    public CourseDTO saveAll(@RequestBody CourseDTO courseDTO){
        System.out.println("Data Save");
        return courseService.save(courseDTO);
    }
}
