package com.xworkz.skanda_XworkzModule.controller;

import com.xworkz.skanda_XworkzModule.dto.XworkzDTO;
import com.xworkz.skanda_XworkzModule.service.XworkzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class XworkzControllerImp {

    @Autowired
    private XworkzService xworkzServiceImp;


    public XworkzControllerImp(){
        System.out.println("X-Workz Controller...");
    }

    @RequestMapping("/signUp")
    public String save(XworkzDTO xworkzDTO){

        System.out.println(xworkzDTO.getUserName());
        System.out.println(xworkzDTO.getPhoneNumber());
        System.out.println(xworkzDTO.getUserEmail());
        System.out.println(xworkzDTO.getUserAdress());
        System.out.println(xworkzDTO.getUserPassword());
        System.out.println(xworkzDTO.getConformPassword());
        System.out.println(xworkzDTO.getGender());

        return "signIn.jsp";

    }




}
