package com.xworkz.skanda_XworkzModule.controller;

import com.xworkz.skanda_XworkzModule.dto.XworkzDTO;
import com.xworkz.skanda_XworkzModule.service.XworkzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class XworkzControllerImp {

    @Autowired
    private XworkzService xworkzServiceImp;


    public XworkzControllerImp(){
        System.out.println("X-Workz Controller...");
    }

    @RequestMapping("/signIn")
    public String save(XworkzDTO xworkzDTO){
        System.out.println("Data: "+xworkzDTO);
        return "display";

    }




}
