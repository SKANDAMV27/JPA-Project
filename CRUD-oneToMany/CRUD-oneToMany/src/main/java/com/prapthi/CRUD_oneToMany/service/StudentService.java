package com.prapthi.CRUD_oneToMany.service;

import com.prapthi.CRUD_oneToMany.dto.SchoolDto;
import com.prapthi.CRUD_oneToMany.dto.StudentDto;
import com.prapthi.CRUD_oneToMany.entity.SchoolEntity;
import com.prapthi.CRUD_oneToMany.entity.StudentEntity;
import com.prapthi.CRUD_oneToMany.repository.SchoolRepository;
import com.prapthi.CRUD_oneToMany.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SchoolRepository schoolRepository; // Needed to fetch existing school

    // Convert StudentDto -> StudentEntity
    public StudentEntity toStudentEntity(StudentDto studentDto){
        if(studentDto == null){
            return null;
        }
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(studentDto.getId());
        studentEntity.setStudentName(studentDto.getStudentName());
        studentEntity.setStudentSection(studentDto.getStudentSection());

        // ✅ FIX: Fetch existing SchoolEntity from DB
        if(studentDto.getSchoolDto() != null && studentDto.getSchoolDto().getId() != 0){
            SchoolEntity schoolEntity = schoolRepository.findById(studentDto.getSchoolDto().getId())
                    .orElseThrow(() -> new RuntimeException("School not found"));
            studentEntity.setSchool(schoolEntity);
        }

        return studentEntity;
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

        if(studentEntity.getSchool() != null){
            // Only include school ID and name to avoid recursion
            SchoolDto schoolDto = new SchoolDto();
            schoolDto.setId(studentEntity.getSchool().getId());
            schoolDto.setSchoolName(studentEntity.getSchool().getSchoolName());
            studentDto.setSchoolDto(schoolDto);
        }

        return studentDto;
    }

    public StudentDto save(StudentDto studentDto){
        StudentEntity studentEntity = toStudentEntity(studentDto);
        StudentEntity saved = studentRepository.save(studentEntity);
        return toStudentDto(saved);
    }
}
