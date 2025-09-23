package com.prapthi.CRUD_OneToOne.controller;

import com.prapthi.CRUD_OneToOne.dto.ResumeDto;
import com.prapthi.CRUD_OneToOne.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;


    @PostMapping("/")
    public ResumeDto saveAll(@RequestBody ResumeDto resumeDto){
        System.out.println("Data Saved Successfully");

        return resumeService.save(resumeDto);
    }

    @GetMapping("/getAll")
    public List<ResumeDto> readAll(@RequestBody ResumeDto resumeDto){
        System.out.println("Get All The Data Read");
        return resumeService.readAll();

    }
}
