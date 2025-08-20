package com.xworkz.skanda_XworkzModule.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class SignInDTO {

    @NotNull(message = "Email Canot Be Null")
    @Email(message = "Invalid Email")
    private String userEmail;

    @NotBlank(message = "Password Cannot Be Blank")
    private String userPassword;
}
