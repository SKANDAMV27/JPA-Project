package com.prapthi.CRUD_oneToMany.service;

import com.prapthi.CRUD_oneToMany.dto.SchoolDto;
import com.prapthi.CRUD_oneToMany.dto.StudentDto;
import com.prapthi.CRUD_oneToMany.entity.SchoolEntity;
import com.prapthi.CRUD_oneToMany.entity.StudentEntity;
import com.prapthi.CRUD_oneToMany.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    // Convert StudentEntity -> StudentDto
    private StudentDto toStudentDto(StudentEntity studentEntity){
        if(studentEntity == null){
            return null;
        }
        StudentDto studentDto = new StudentDto();
        studentDto.setId(studentEntity.getId());
        studentDto.setStudentName(studentEntity.getStudentName());
        studentDto.setStudentSection(studentEntity.getStudentSection());
        return studentDto;
    }

    // Convert StudentDto -> StudentEntity
    private StudentEntity toStudentEntity(StudentDto studentDto){
        if(studentDto == null){
            return null;
        }
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(studentDto.getId());
        studentEntity.setStudentName(studentDto.getStudentName());
        studentEntity.setStudentSection(studentDto.getStudentSection());
        return studentEntity;
    }

    // Convert SchoolEntity -> SchoolDto
    private SchoolDto toSchoolDto(SchoolEntity schoolEntity){
        if(schoolEntity == null){
            return null;
        }
        SchoolDto schoolDto = new SchoolDto();
        schoolDto.setId(schoolEntity.getId());
        schoolDto.setSchoolName(schoolEntity.getSchoolName());
        schoolDto.setSchoolCity(schoolEntity.getSchoolCity());
        schoolDto.setSchoolType(schoolEntity.getSchoolType());

        if(schoolEntity.getStudents() != null){
            List<StudentDto> studentDtos = schoolEntity.getStudents()
                    .stream()
                    .map(this::toStudentDto)
                    .collect(Collectors.toList());
            schoolDto.setStudentDtos(studentDtos);
        }
        return schoolDto;
    }

    // Convert SchoolDto -> SchoolEntity
    private SchoolEntity toSchoolEntity(SchoolDto schoolDto){
        if(schoolDto == null){
            return null;
        }
        SchoolEntity schoolEntity = new SchoolEntity();
        schoolEntity.setId(schoolDto.getId());
        schoolEntity.setSchoolName(schoolDto.getSchoolName());
        schoolEntity.setSchoolCity(schoolDto.getSchoolCity());
        schoolEntity.setSchoolType(schoolDto.getSchoolType());

        if(schoolDto.getStudentDtos() != null){
            List<StudentEntity> students = schoolDto.getStudentDtos()
                    .stream()
                    .map(this::toStudentEntity)
                    .collect(Collectors.toList());


            students.forEach(student -> student.setSchool(schoolEntity));

            schoolEntity.setStudents(students);
        }
        return schoolEntity;
    }

    public SchoolDto save(SchoolDto schoolDto){
        System.out.println("Data Save");
        SchoolEntity schoolEntity = toSchoolEntity(schoolDto);
        SchoolEntity save = schoolRepository.save(schoolEntity);
         return toSchoolDto(save);
    }

    public List<SchoolDto> findAll(){
        System.out.println("Get All The Data");
         return schoolRepository.findAll().stream().map(this::toSchoolDto).toList();
    }

    public SchoolDto findById(long id) {
        System.out.println("Get Data By Id");
        return schoolRepository.findById(id)
                .map(this::toSchoolDto)
                .orElseThrow(() -> new RuntimeException("School not found with id " + id));
    }

    public SchoolDto updateById(long id, SchoolDto schoolDto) {
        return schoolRepository.findById(id).map(existingSchool -> {

            existingSchool.setSchoolName(schoolDto.getSchoolName());
            existingSchool.setSchoolCity(schoolDto.getSchoolCity());
            existingSchool.setSchoolType(schoolDto.getSchoolType());

            if (schoolDto.getStudentDtos() != null) {
                existingSchool.getStudents().clear();
                existingSchool.getStudents().addAll(
                        schoolDto.getStudentDtos().stream()
                                .map(this::toStudentEntity)
                                .toList()
                );
            }
            SchoolEntity updated = schoolRepository.save(existingSchool);
            return toSchoolDto(updated);
        }).orElseThrow(() -> new RuntimeException("School not found with id " + id));
    }

    }



