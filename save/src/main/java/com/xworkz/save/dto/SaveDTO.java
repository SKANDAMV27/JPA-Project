package com.xworkz.save.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveDTO {

    private String name;

    private String email;

    private int age;

    private long number;
}
