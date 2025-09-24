package com.prapthi.CRUD_oneToMany.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDto {
    private long id;
    private String schoolName;
    private String schoolCity;
    private String schoolType;

    @JsonManagedReference
    private List<StudentDto> studentDtos;
}
