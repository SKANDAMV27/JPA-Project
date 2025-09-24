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

    // Convert SchoolEntity -> SchoolDto
    public SchoolDto toSchoolDto(SchoolEntity schoolEntity){
        if(schoolEntity == null){
            return null;
        }
        SchoolDto schoolDto = new SchoolDto();
        schoolDto.setId(schoolEntity.getId());
        schoolDto.setSchoolName(schoolEntity.getSchoolName());
        schoolDto.setSchoolCity(schoolEntity.getSchoolCity());
        schoolDto.setSchoolType(schoolEntity.getSchoolType());
        return schoolDto;
    }

    // Convert SchoolDto -> SchoolEntity
    public SchoolEntity toSchoolEntity(SchoolDto schoolDto){
        if(schoolDto == null){
            return null;
        }
        SchoolEntity schoolEntity = new SchoolEntity();
        schoolEntity.setId(schoolDto.getId());
        schoolEntity.setSchoolName(schoolDto.getSchoolName());
        schoolEntity.setSchoolCity(schoolDto.getSchoolCity());
        schoolEntity.setSchoolType(schoolDto.getSchoolType());
        return schoolEntity;
    }

    // Convert StudentEntity -> StudentDto
    public StudentDto toStudentDto(StudentEntity studentEntity){
        if(studentEntity == null){
            return null;
        }
        StudentDto studentDto = new StudentDto();
        studentDto.setId(studentEntity.getId());
        studentDto.setStudentName(studentEntity.getStudentName());
        studentDto.setStudentSection(studentEntity.getStudentSection());

        // ✅ Add school info if available
        if(studentEntity.getSchool() != null){
            studentDto.setSchoolDto(toSchoolDto(studentEntity.getSchool()));
        }

        return studentDto;
    }

    // Convert StudentDto -> StudentEntity
    public StudentEntity toStudentEntity(StudentDto studentDto){
        if(studentDto == null){
            return null;
        }
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(studentDto.getId());
        studentEntity.setStudentName(studentDto.getStudentName());
        studentEntity.setStudentSection(studentDto.getStudentSection());


        if(studentDto.getSchoolDto() != null){
            SchoolEntity schoolEntity = toSchoolEntity(studentDto.getSchoolDto());
            studentEntity.setSchool(schoolEntity);
        }

        return studentEntity;
    }

    public StudentDto save(StudentDto studentDto){
          StudentEntity studentEntity =  toStudentEntity(studentDto);
          StudentEntity save =  studentRepository.save(studentEntity);
          return toStudentDto(save);
    }
}
