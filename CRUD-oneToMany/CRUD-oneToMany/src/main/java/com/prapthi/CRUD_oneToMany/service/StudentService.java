package com.prapthi.CRUD_oneToMany.service;

import com.prapthi.CRUD_oneToMany.dto.SchoolDto;
import com.prapthi.CRUD_oneToMany.dto.StudentDto;
import com.prapthi.CRUD_oneToMany.entity.SchoolEntity;
import com.prapthi.CRUD_oneToMany.entity.StudentEntity;
import com.prapthi.CRUD_oneToMany.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public SchoolDto toSchoolDto(SchoolEntity schoolEntity){
        if(schoolEntity==null){
            return null;
        }
        SchoolDto schoolDto = new SchoolDto();
        schoolDto.setId(schoolEntity.getId());
        schoolDto.setSchoolName(schoolEntity.getSchoolName());
        schoolDto.setSchoolCity(schoolDto.getSchoolCity());
        schoolDto.setSchoolType(schoolEntity.getSchoolType());
        return schoolDto;
    }

    public SchoolEntity toSchoolEntity(SchoolDto schoolDto){
        if(schoolDto==null){
            return null;
        }
        SchoolEntity schoolEntity = new SchoolEntity();
        schoolEntity.setId(schoolDto.getId());
        schoolEntity.setSchoolName(schoolDto.getSchoolName());
        schoolEntity.setSchoolCity(schoolDto.getSchoolCity());
        schoolEntity.setSchoolType(schoolDto.getSchoolType());
        return schoolEntity;
    }

    public StudentDto studentDto(StudentEntity studentEntity){
        if(studentEntity==null){
            return null;
        }
        StudentDto studentDto = new StudentDto();
        studentDto.setId(studentEntity.getId());
        studentDto.setStudentName(studentEntity.getStudentName());
        studentDto.setStudentSection(studentEntity.getStudentSection());
        if(studentEntity.get)


    }


}
