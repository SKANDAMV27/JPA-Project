package com.prapthi.CRUD_oneToMany.controller;

import com.prapthi.CRUD_oneToMany.dto.SchoolDto;
import com.prapthi.CRUD_oneToMany.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SchoolController {

    @Autowired
    private SchoolService service;

    @PostMapping("/save")
    public SchoolDto saveData(SchoolDto schoolDto){
        System.out.println("Data Save Successfully");
        return service.save(schoolDto);

    }
}
