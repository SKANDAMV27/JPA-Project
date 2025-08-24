package com.xworkz.save.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveDto {

    @NotNull
    @Size(min=3,max=30,message = "Name Should be Min 3 and Max 30 In Size")
    private String name;

    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",
            message = "Invalid email format or It already it already exist ")
    private String email;

    @NotNull
    @Min(value = 15,message = "Age Should Be 18+")
    @Max(value = 50,message = "Age Should Not Be More Than 50")
    private int age;
    @NotNull
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Phone number must start with 6,7,8 or 9 and be 10 digits long or It already it already exist  ")
    private String number;

//    public SaveDto(){
//        System.out.println("Saved DTO.,.\uD83D\uDE06");
//    }
}
