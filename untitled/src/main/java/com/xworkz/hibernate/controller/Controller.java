package com.xworkz.hibernate.controller;

import com.xworkz.hibernate.dto.StudentDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Component
@RequestMapping("/")
public class Controller {

    @RequestMapping("save")
    public void saveData(@Valid StudentDto dto, BindingResult bindingResult){
        System.out.println(bindingResult.hasErrors());
    }
}
