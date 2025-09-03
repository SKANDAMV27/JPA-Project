package com.xworkz.skanda_XworkzModule.controller;

import com.xworkz.skanda_XworkzModule.dto.EmailDTO;
import com.xworkz.skanda_XworkzModule.dto.SignInDTO;
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
            model.addAttribute("password", "Passwords do not match");
            System.out.println("Password Don't Match ");
            return "signUp";
        }
        else {


            //  Save to DB
            String value = xworkzServiceImp.save(xworkzDTO);
            System.out.println("Saved -> " + value);

            model.addAttribute("success", "Registration successful!");
            return "signIn";
        }
    }

    @RequestMapping("/signIn")
    public String signInValidation(@Valid @ModelAttribute SignInDTO xworkzDTO,
                                   BindingResult bindingResult,
                                   Model model) {

        System.out.println("X-Workz Controller");

        // Handle validation errors (like email blank, password blank etc.)
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError error : errors) {
                System.out.println(error.getDefaultMessage());
            }
            model.addAttribute("error", "Please correct the highlighted errors.");
            return "signIn";
        }

        // Call service
        String result = xworkzServiceImp.signInValidation(
                xworkzDTO.getUserEmail(),
                xworkzDTO.getUserPassword()
        );

        if ("SUCCESS".equals(result)) {
            model.addAttribute("message", "SignIn Successfully");
            return "display";
        } else {
            // Any other message comes from service (invalid password, locked account, etc.)
            model.addAttribute("error", result);
            return "signIn";
        }
    }



//    @RequestMapping("/forgotPassword")
//    public String sendOTP(@Valid EmailDTO emailDTO,BindingResult bindingResult,Model model){
//        System.out.println("OPT Sent Controller Method");
//        if(bindingResult.hasErrors()){
//            System.out.println("Send OTP Method In Side if Else");
//            return "forgotPassword";
//        }
//
//        System.out.println("..OPT Send Out Side The if Condition..");
//        return "forgotPassword";
//    }
}





