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

    // ✅ Save
    public SchoolDto save(SchoolDto schoolDto) {
        SchoolEntity schoolEntity = toSchoolEntity(schoolDto);
        schoolEntity.getStudents().forEach(student -> student.setSchool(schoolEntity));
        SchoolEntity saved = schoolRepository.save(schoolEntity);
        return toSchoolDto(saved);
    }

    // ✅ Find All
    public List<SchoolDto> findAll() {
        return schoolRepository.findAll()
                .stream()
                .map(this::toSchoolDto)
                .collect(Collectors.toList());
    }

    // ✅ Find By Id
    public SchoolDto findById(long id) {
        return schoolRepository.findById(id)
                .map(this::toSchoolDto)
                .orElseThrow(() -> new RuntimeException("School not found with id: " + id));
    }

    // ✅ Update By Id
    public SchoolDto updateById(long id, SchoolDto schoolDto) {
        return schoolRepository.findById(id).map(existingSchool -> {
            existingSchool.setSchoolName(schoolDto.getSchoolName());
            existingSchool.setSchoolCity(schoolDto.getSchoolCity());
            existingSchool.setSchoolType(schoolDto.getSchoolType());

            if (schoolDto.getStudentDtos() != null) {
                existingSchool.getStudents().clear();
                List<StudentEntity> updatedStudents = schoolDto.getStudentDtos()
                        .stream()
                        .map(this::toStudentEntity)
                        .collect(Collectors.toList());

                updatedStudents.forEach(student -> student.setSchool(existingSchool));
                existingSchool.getStudents().addAll(updatedStudents);
            }

            SchoolEntity updated = schoolRepository.save(existingSchool);
            return toSchoolDto(updated);
        }).orElseThrow(() -> new RuntimeException("School not found with id: " + id));
    }

    // ✅ Delete
    public void deleteById(long id) {
        schoolRepository.deleteById(id);
    }

    // ---------------- Mappers ---------------- //

    private SchoolDto toSchoolDto(SchoolEntity schoolEntity) {
        if (schoolEntity == null) return null;

        SchoolDto schoolDto = new SchoolDto();
        schoolDto.setId(schoolEntity.getId());
        schoolDto.setSchoolName(schoolEntity.getSchoolName());
        schoolDto.setSchoolCity(schoolEntity.getSchoolCity());
        schoolDto.setSchoolType(schoolEntity.getSchoolType());

        if (schoolEntity.getStudents() != null) {
            List<StudentDto> studentDtos = schoolEntity.getStudents()
                    .stream()
                    .map(student -> toStudentDto(student, schoolDto)) // ✅ pass parent
                    .collect(Collectors.toList());
            schoolDto.setStudentDtos(studentDtos);
        }
        return schoolDto;
    }

    private StudentDto toStudentDto(StudentEntity studentEntity, SchoolDto parentSchoolDto) {
        if (studentEntity == null) return null;

        StudentDto studentDto = new StudentDto();
        studentDto.setId(studentEntity.getId());
        studentDto.setStudentName(studentEntity.getStudentName());
        studentDto.setStudentSection(studentEntity.getStudentSection());
        studentDto.setSchoolDto(parentSchoolDto); // ✅ set parent
        return studentDto;
    }

    private SchoolEntity toSchoolEntity(SchoolDto schoolDto) {
        if (schoolDto == null) return null;

        SchoolEntity schoolEntity = new SchoolEntity();
        schoolEntity.setId(schoolDto.getId());
        schoolEntity.setSchoolName(schoolDto.getSchoolName());
        schoolEntity.setSchoolCity(schoolDto.getSchoolCity());
        schoolEntity.setSchoolType(schoolDto.getSchoolType());

        if (schoolDto.getStudentDtos() != null) {
            List<StudentEntity> students = schoolDto.getStudentDtos()
                    .stream()
                    .map(this::toStudentEntity)
                    .collect(Collectors.toList());
            students.forEach(student -> student.setSchool(schoolEntity));
            schoolEntity.setStudents(students);
        }
        return schoolEntity;
    }

    private StudentEntity toStudentEntity(StudentDto studentDto) {
        if (studentDto == null) return null;

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(studentDto.getId());
        studentEntity.setStudentName(studentDto.getStudentName());
        studentEntity.setStudentSection(studentDto.getStudentSection());
        return studentEntity;
    }
}
