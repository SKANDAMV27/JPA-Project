package com.prapthi.CRUD_oneToMany.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private long id;
    private String studentName;
    private String studentSection;

    @JsonBackReference
    private SchoolDto schoolDto;
}
