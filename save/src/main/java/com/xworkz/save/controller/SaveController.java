package com.xworkz.save.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class SaveController {

    public SaveController()
    {
        System.out.println("no  args of Controller...");
    }

    @RequestMapping("/save")
    public String save(Model model,@RequestParam String name,@RequestParam String email,@RequestParam int age,@RequestParam long number){

        model.addAttribute("name","Name: "+name);
        model.addAttribute("email",email);
        model.addAttribute("age",age);
        model.addAttribute("phone",number);

        System.out.println("Details");
        System.out.println("Name: "+name);
        System.out.println("Email: "+email);
        System.out.println("Age: "+age);
        System.out.println("Phone Number: "+number);
        return "result.jsp";
    }
}
