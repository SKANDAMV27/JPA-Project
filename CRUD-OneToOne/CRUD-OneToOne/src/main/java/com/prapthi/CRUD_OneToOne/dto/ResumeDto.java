package com.prapthi.CRUD_OneToOne.dto;

import com.prapthi.CRUD_OneToOne.entity.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDto {

    private long id;

    private String context;

    private StudentDto student;

}
