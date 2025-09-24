package com.prapthi.CRUD_oneToMany.dto;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDto {


    private long id;

    private String schoolName;

    private String schoolCity;

    private String schoolType;

    private StudentDto studentDto;

}
