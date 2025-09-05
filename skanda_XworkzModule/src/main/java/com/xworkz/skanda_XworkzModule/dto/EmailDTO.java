package com.xworkz.skanda_XworkzModule.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class EmailDTO {

    @NotBlank(message = "Email Field Not Be Blank")
    @Email(message = "Enter The Valid Email")
    private String email;

    private String name;
}
