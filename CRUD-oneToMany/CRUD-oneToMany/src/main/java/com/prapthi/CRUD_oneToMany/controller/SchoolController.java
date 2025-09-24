package com.prapthi.CRUD_oneToMany.controller;

import com.prapthi.CRUD_oneToMany.dto.SchoolDto;
import com.prapthi.CRUD_oneToMany.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SchoolController {

    @Autowired
    private SchoolService service;

    @PostMapping("/save")
    public SchoolDto saveData(@RequestBody SchoolDto schoolDto){
        System.out.println("Data Save Successfully");
        return service.save(schoolDto);
    }

    @GetMapping("/getAll")
    public List<SchoolDto> getAll(@RequestBody SchoolDto schoolDto){
        System.out.println("Get All The Data");
        return service.findAll();
    }

    @GetMapping("/getById")
    public SchoolDto getById(long id){
        System.out.println("Get The Data By Id");
        return service.findById(id);

    }
}
