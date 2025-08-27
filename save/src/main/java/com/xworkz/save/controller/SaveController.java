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
//import org.springframework.web.bind.annotation.RequestParam;
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
        System.out.println("no  args of Controller..☺.");
    }



    @RequestMapping("/save")
    public String save(Model model, @Valid SaveDto saveDto, BindingResult bindingResult) {

        //  form validation errors
        if (bindingResult.hasErrors()) {
            List<ObjectError> objectErrorList = bindingResult.getAllErrors();
            for (ObjectError objectError : objectErrorList) {
                System.out.println(objectError.getDefaultMessage());
            }
            model.addAttribute("errors", objectErrorList);
            model.addAttribute("errorMessage", "Correct your form");
            return "save"; // back to form page
        }

        // email is already in the db
        boolean exists = saveServiceImpl.checkEmailAndNumber(saveDto.getEmail(), saveDto.getNumber(),saveDto.getName());
        if (exists) {
            model.addAttribute("errorMessage", "Email or Phone Number already exists ");
            return "save"; // back to form page
        }

        // Step 3: Save data if valid and unique
        String value = saveServiceImpl.save(saveDto);
        System.out.println(value);

        model.addAttribute("success", "Success ✅");

        model.addAttribute("name", "Name: " + saveDto.getName());
        model.addAttribute("email", saveDto.getEmail());
        model.addAttribute("age", saveDto.getAge());
        model.addAttribute("phone", saveDto.getNumber());

        System.out.println("Details");
        System.out.println("Name: " + saveDto.getName());
        System.out.println("Email: " + saveDto.getEmail());
        System.out.println("Age: " + saveDto.getAge());
        System.out.println("Phone Number: " + saveDto.getNumber());

        return "result"; // success page
    }

//    @RequestMapping("/save")
//    public String checkEmailAndNumber(String email,String number,Model model){
//        System.out.println("Check Email and Number is is already in the DB");
//
//        boolean check = saveServiceImpl.checkEmailAndNumber(email,number);
//        if(check){
//            System.out.println("It Already Exist");
//            model.addAttribute("name","Already in the DB");
//            return "save";
//        }
//            System.out.println("It is not Already in DB");
//            model.addAttribute("email","Already not in the DB");
//
//
//        return "result";
//    }


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

    @RequestMapping("/delete")
    public String delete(SaveDto saveDto,Model model){
        System.out.println("Delete Controller");
        model.addAttribute("name",saveDto.getName());
        System.out.println(saveDto.getName());
        String result = saveServiceImpl.delete(saveDto);
        System.out.println(result);
        model.addAttribute("result",result);
        return "resultDelete";
    }

    @RequestMapping("/update")
    public String update(@Valid SaveDto saveDto,Model model,BindingResult bindingResult){
        System.out.println("Update Controller");
        //  form validation errors
        if (bindingResult.hasErrors()) {
            List<ObjectError> objectErrorList = bindingResult.getAllErrors();
            for (ObjectError objectError : objectErrorList) {
                System.out.println(objectError.getDefaultMessage());
            }
            model.addAttribute("errors", objectErrorList);
            model.addAttribute("errorMessage", "Correct your form");
            return "updateName"; // back to form page
        }

        boolean save = saveServiceImpl.updateTheRow(saveDto);
        model.addAttribute("name","Updated Name: "+saveDto.getName());
        model.addAttribute("email","Updated Email:"+saveDto.getEmail());
        model.addAttribute("age","Age: "+saveDto.getAge());
        model.addAttribute("number","Number: "+saveDto.getNumber());

        System.out.println(save);

        return "result";
    }







}
