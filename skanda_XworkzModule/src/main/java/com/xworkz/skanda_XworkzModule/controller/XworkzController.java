package com.xworkz.skanda_XworkzModule.controller;

import com.xworkz.skanda_XworkzModule.dto.XworkzDTO;
import com.xworkz.skanda_XworkzModule.service.XworkzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class XworkzController {

    @Autowired
    private XworkzService xworkzServiceImp;


    public XworkzController() {
        System.out.println("X-Workz Controller...");
    }

//    @RequestMapping("/signUp")
//    public String save(@Valid  XworkzDTO xworkzDTO , BindingResult result, Model model){

    //        if (result.hasErrors()){
//            List<ObjectError> objectErrorList=result.getAllErrors();
//            for (ObjectError objectError:objectErrorList){
//                System.out.println(objectError.getDefaultMessage());
//            }
//            model.addAttribute("errors",objectErrorList);
//            model.addAttribute("errorMessage","correct your form");
//            return "signUp";
//        }
//        String value = xworkzServiceImp.save(xworkzDTO);
//        System.out.println(value);
//        model.addAttribute("success","Success");
//        return "sigIn";
    @RequestMapping("/signUp")
    public String save(@Valid XworkzDTO xworkzDTO, BindingResult result, Model model) {

        // Backend validation errors
        if (result.hasErrors()) {
            List<ObjectError> objectErrorList = result.getAllErrors();
            for (ObjectError error : objectErrorList) {
                System.out.println(error.getDefaultMessage());
            }
            model.addAttribute("errors", objectErrorList);
            model.addAttribute("errorMessage", "Correct your form details");
            return "signUp"; // return back to form
        }

        //  Check confirm password
        if (!xworkzDTO.getUserPassword().equals(xworkzDTO.getConformPassword())) {
            model.addAttribute("errorMessage", "Passwords do not match");
            return "signUp";
        }

        //  Save to DB
        String value = xworkzServiceImp.save(xworkzDTO);
        System.out.println("Saved -> " + value);

        model.addAttribute("success", "Registration successful!");
        return "signIn"; // redirect to signIn.jsp
    }

    @RequestMapping("/signIn")
    public String signInValidation(@RequestParam("userEmail") String userEmail,
                                         @RequestParam("userName") String userName,
                                         ModelAndView modelAndView) {

        if (xworkzServiceImp.signInValidation(userName, userEmail)) {
            modelAndView.setViewName("Welcome");
            modelAndView.addObject("message", "SignIn Successfully");
        } else {
            modelAndView.setViewName("signIn");
            modelAndView.addObject("error", "Invalid credentials! Please try again.");
        }
        return "index.jsp";
    }
}





