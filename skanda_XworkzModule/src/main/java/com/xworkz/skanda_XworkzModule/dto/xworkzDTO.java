package com.xworkz.skanda_XworkzModule.dto;


import jakarta.validation.constraints.Size;

public class xworkzDTO {
    @Size(max = 10,min = 3,message = "Name Should Max 10 and Min 3")
    private String userName;

    private String phoneNumber;
}
