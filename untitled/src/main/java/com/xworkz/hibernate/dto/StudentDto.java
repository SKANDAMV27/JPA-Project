package com.xworkz.hibernate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    @NotBlank
    @NotEmpty
    @NotNull
    @Size(min = 5,max = 10)
    private String name;

    @NotBlank
    @NotEmpty
    @NotNull
    private String email;
}
