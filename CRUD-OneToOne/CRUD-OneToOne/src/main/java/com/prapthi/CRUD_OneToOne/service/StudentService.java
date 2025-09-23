package com.prapthi.CRUD_OneToOne.service;

import com.prapthi.CRUD_OneToOne.dto.ResumeDto;
import com.prapthi.CRUD_OneToOne.dto.StudentDto;
import com.prapthi.CRUD_OneToOne.entity.ResumeEntity;
import com.prapthi.CRUD_OneToOne.entity.StudentEntity;
import com.prapthi.CRUD_OneToOne.repositry.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private ResumeDto toResumeDto(ResumeEntity resume){
        if(resume == null) return null;
        ResumeDto dto = new ResumeDto();
        dto.setId(resume.getId());
        dto.setContext(resume.getContext());
        dto.setStudentId(null);
        return dto;
    }

    private ResumeEntity toResumeEntity(ResumeDto resumeDto){
        if(resumeDto == null)
            return null;
        ResumeEntity resume = new ResumeEntity();
        resume.setId(resumeDto.getId());
        resume.setContext(resumeDto.getContext());
        resume.setStudent(null);
        return resume;
    }

    public StudentDto toDto(StudentEntity student){
        if(student == null)
            return null;
        return new StudentDto(
                student.getId(),
                student.getStudentName(),
                student.getStudentDept(),
                student.getStudentContactNumber(),
                toResumeDto(student.getResumeEntity())
        );
    }

    public StudentEntity toEntity(StudentDto studentDto){
        if(studentDto == null)
            return null;
        StudentEntity student = new StudentEntity();
        student.setId(studentDto.getId());
        student.setStudentName(studentDto.getStudentName());
        student.setStudentDept(studentDto.getStudentDept());
        student.setStudentContactNumber(studentDto.getStudentContactNumber());
        toResumeEntity(studentDto.getResumeDto());
//        if(resume != null){
//            resume.setStudent(student);
//            student.setResumeEntity(resume);
//        }
        return student;
    }

    public StudentDto save(StudentDto studentDto){
        StudentEntity studentEntity = toEntity(studentDto);
        StudentEntity saved = studentRepository.save(studentEntity);
        return toDto(saved);
    }

    public List<StudentDto> getAll(){
        List<StudentEntity> findAll = studentRepository.findAll();
        return findAll.stream().map(this::toDto).collect(Collectors.toList());

    }
}
