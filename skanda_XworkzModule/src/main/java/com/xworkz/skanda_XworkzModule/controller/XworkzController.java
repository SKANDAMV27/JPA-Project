package com.xworkz.skanda_XworkzModule.controller;

import com.xworkz.skanda_XworkzModule.dto.XworkzDTO;
import com.xworkz.skanda_XworkzModule.service.XworkzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class XworkzController {

    @Autowired
    private XworkzService xworkzServiceImp;


    public XworkzController(){
        System.out.println("X-Workz Controller...");
    }

    @RequestMapping("/signUp")
    public String save(@Valid  XworkzDTO xworkzDTO , BindingResult result, Model model){

        if (result.hasErrors()){
            List<ObjectError> objectErrorList=result.getAllErrors();
            for (ObjectError objectError:objectErrorList){
                System.out.println(objectError.getDefaultMessage());
            }
            model.addAttribute("errors",objectErrorList);
            model.addAttribute("errorMessage","correct your form");
            return "signUp";
        }
        String value = xworkzServiceImp.save(xworkzDTO);
        System.out.println(value);
        model.addAttribute("success","Success");
        return "signIn";

    }




}
