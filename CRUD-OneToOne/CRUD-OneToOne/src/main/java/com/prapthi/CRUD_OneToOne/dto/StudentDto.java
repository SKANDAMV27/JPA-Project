package com.prapthi.CRUD_OneToOne.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private long id;
    private String studentName;
    private String studentDept;
    private String studentContactNumber;
    private ResumeDto resumeDto;
}
