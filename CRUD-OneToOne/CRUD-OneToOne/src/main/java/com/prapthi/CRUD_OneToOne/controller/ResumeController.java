package com.prapthi.CRUD_OneToOne.controller;

import com.prapthi.CRUD_OneToOne.dto.ResumeDto;
import com.prapthi.CRUD_OneToOne.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;


    @PostMapping("/")
    public ResumeDto saveAll(ResumeDto resumeDto){
        System.out.println("Data Saved Successfully");

        return resumeService.save(resumeDto);
    }
}
