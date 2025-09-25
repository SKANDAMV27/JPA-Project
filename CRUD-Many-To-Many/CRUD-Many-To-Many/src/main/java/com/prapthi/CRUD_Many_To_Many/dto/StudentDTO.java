package com.prapthi.CRUD_Many_To_Many.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private int id;

    private String studentName;

    private String studentBranch;

//    @JsonBackReference
    private List<CourseDTO> courseDTOList;


}
