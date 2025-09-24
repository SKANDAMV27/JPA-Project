package com.prapthi.CRUD_oneToMany.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private long id;
    private String studentName;
    private char studentSection;

    private SchoolDto schoolDto;
}
