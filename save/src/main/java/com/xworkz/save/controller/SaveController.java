package com.xworkz.save.controller;


import com.xworkz.save.dto.SaveDto;
import com.xworkz.save.entity.SaveEntity;
import com.xworkz.save.service.SaveService;
import com.xworkz.save.service.SaveServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class SaveController {

    @Autowired
    private SaveService saveServiceImpl;

    public SaveController()
    {
        System.out.println("no  args of Controller...");
    }



    @RequestMapping("/save")
    public String save(Model model, @Valid SaveDto saveDto, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            List<ObjectError> objectErrorList=bindingResult.getAllErrors();
            for (ObjectError objectError:objectErrorList){
                System.out.println(objectError.getDefaultMessage());
            }
            model.addAttribute("errors", objectErrorList);
            model.addAttribute("errorMessage","correct your form");
            System.out.println(objectErrorList);
            return "save";
        }
        String value = saveServiceImpl.save(saveDto);
        System.out.println(value);
        model.addAttribute("success","Success");





        model.addAttribute("name","Name: "+saveDto.getName());
        model.addAttribute("email",saveDto.getEmail());
        model.addAttribute("age",saveDto.getAge());
        model.addAttribute("phone",saveDto.getNumber());

        System.out.println("Details");
        System.out.println("Name: "+saveDto.getName());
        System.out.println("Email: "+saveDto.getEmail());
        System.out.println("Age: "+saveDto.getAge());
        System.out.println("Phone Number: "+saveDto.getNumber());

        return "result";
    }


    @RequestMapping("/view")
    public ModelAndView getAllData(ModelAndView modelAndView,Model model) {
        System.out.println("Fetching all data...");

        List<SaveEntity> list = saveServiceImpl.getAll();

        System.out.println("Retrieved list: " + list);

        modelAndView.addObject("entity", list);
        modelAndView.setViewName("view"); // matches JSP filename

//        model.addAttribute("name","list"+list);




        return modelAndView;
    }



}
