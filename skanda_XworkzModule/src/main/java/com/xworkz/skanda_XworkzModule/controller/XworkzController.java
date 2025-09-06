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
        if (!xworkzDTO.getUserPassword().equals(xworkzDTO.getConfirmPassword())) {
            model.addAttribute("password", "Passwords do not match");
            System.out.println(xworkzDTO.getUserPassword()+" "+xworkzDTO.getConfirmPassword());
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
    public String signInValidation(@Valid @ModelAttribute SignInDTO signInDTO,
                                   BindingResult bindingResult,
                                   Model model) {
        System.out.println("X-Workz Controller");

        if (bindingResult.hasErrors()) {
            return "signIn";
        }

        String result = xworkzServiceImp.signInValidation(signInDTO.getUserEmail(), signInDTO.getUserPassword());
        System.out.println("Result: "+result);

        switch (result) {
            case "SUCCESS":
                model.addAttribute("message", "SignIn Successfully");
                return "xworkz";

            case "INVALID_EMAIL":
                model.addAttribute("error", "Invalid email! Please try again.");
                return "signIn";

            case "INVALID_PASSWORD":
                model.addAttribute("error", "Invalid password! Please try again.");
                return "signIn";

            case "LOCKED":
                model.addAttribute("error", "Your account is locked. Try again after 24 hours.");
                return "signIn";

            case "LOCKED_NOW":
                model.addAttribute("error", "Your account has been locked due to 3 failed attempts.");
                return "signIn";

            default:
                model.addAttribute("error", "Login failed! Please try again.");
                return "signIn";
        }
    }





    @RequestMapping("/forgotPassword")
    public String sendOTP(@Valid EmailDTO emailDTO,BindingResult bindingResult,Model model){
        System.out.println("OPT Sent Controller Method");
        if(bindingResult.hasErrors()) {
            List<ObjectError> objectErrorList = bindingResult.getAllErrors();
            for (ObjectError objectError : objectErrorList) {
                model.addAttribute("error","Email cannot be Exist");
                System.out.println("Invalid.,");
                System.out.println(objectError.getDefaultMessage());
                return "forgotPassword";
            }
        }

        System.out.println("After if statement");
        String result = xworkzServiceImp.sendOTP(emailDTO.getEmail(),emailDTO);
        System.out.println("OTP Send: "+result);
        System.out.println("OTP Send To: "+emailDTO.getEmail());
        return "forgotPassword";
    }

    @RequestMapping("/VerifyOTP")
    public String VerifyOTP(XworkzDTO xworkzDTO,Model model){
        System.out.println("Verify OTP Controller");

        return "passwordChange";
    }

    @RequestMapping("/deleteAccount")
    public String delete(XworkzDTO xworkzDTO,Model model){
        System.out.println("Delete The Account Controller");
        String result = xworkzServiceImp.delete(xworkzDTO);
        model.addAttribute("error","Email doesnot Exist");
        System.out.println(result);

        return "deleteResult";
    }


}





