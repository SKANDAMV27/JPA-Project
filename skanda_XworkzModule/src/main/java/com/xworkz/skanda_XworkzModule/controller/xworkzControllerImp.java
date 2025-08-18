package com.xworkz.skanda_XworkzModule.controller;

import com.xworkz.skanda_XworkzModule.entity.xworkzEntity;
import com.xworkz.skanda_XworkzModule.repositry.xworkzRepositryImp;
import com.xworkz.skanda_XworkzModule.service.xworkzService;
import com.xworkz.skanda_XworkzModule.service.xworkzServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class xworkzControllerImp {

    @Autowired
    private xworkzServiceImp xworkzServiceImp;

    @RequestMapping("/signIn.jsp")
    public ModelAndView save(xworkzEntity xworkz,ModelAndView modelAndView){
        System.out.println("Id: "+xworkz.getId());
        System.out.println("Name: "+xworkz.getUserName());
        System.out.println("Email: "+xworkz.getUserEmail());
        System.out.println("Phone Number: "+xworkz.getPhoneNumber());
        System.out.println("Password: "+xworkz.getUserPassword());
        System.out.println("Confrom Password: "+xworkz.getConformPassword());
        System.out.println("Adress: "+xworkz.getUserAdress());
        System.out.println("Gender: "+xworkz.getUserGender());


        return modelAndView;
    }



}
