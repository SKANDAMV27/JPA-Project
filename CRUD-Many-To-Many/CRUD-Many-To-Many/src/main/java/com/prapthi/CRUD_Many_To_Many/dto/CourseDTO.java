package com.prapthi.CRUD_Many_To_Many.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    private int id;

    private String courseName;

//    @JsonBackReference
    private List<StudentDTO> studentDTOList;
}
