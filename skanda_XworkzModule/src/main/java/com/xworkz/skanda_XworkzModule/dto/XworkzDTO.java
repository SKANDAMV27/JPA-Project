package com.xworkz.skanda_XworkzModule.dto;



import lombok.Data;

import javax.persistence.Transient;
import javax.validation.constraints.*;

@Data
public class XworkzDTO {
    @NotNull
    @Size(min=3 , max=10,message = "Name Must be Min 3 and Max 10")
    private String userName;

    @NotNull
    @Pattern(regexp = "^9876\\d{6}$", message = "Phone number must start with 9876 and be 10 digits long")
    private long phoneNumber;

    @NotNull
    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",
            message = "Invalid email format")
    private String userEmail;

    @NotNull
    @Max(value = 15,message = "Age Should be 15+")
    @Max(value = 50,message = "Age Must be less than 50")
    private int userAge;
    @NotNull
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must be at least 8 characters long, contain upper & lower case letters, a number and a special character"
    )
    private String userPassword;
    @Transient
    private String conformPassword;
    @NotBlank
    private String userAdress;
    @Pattern(
            regexp = "^(m|f|o)$",
            message = "Gender must be male, female, or other"
    )
    private String gender;

}
