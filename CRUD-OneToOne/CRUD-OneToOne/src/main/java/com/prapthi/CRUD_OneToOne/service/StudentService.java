package com.prapthi.CRUD_OneToOne.service;

import com.prapthi.CRUD_OneToOne.dto.ResumeDto;
import com.prapthi.CRUD_OneToOne.dto.StudentDto;
import com.prapthi.CRUD_OneToOne.entity.ResumeEntity;
import com.prapthi.CRUD_OneToOne.entity.StudentEntity;
import com.prapthi.CRUD_OneToOne.repositry.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    private ResumeDto toResumeDto(ResumeEntity resumeEntity) {
        if (resumeEntity == null) {
            return null;
        }
        return new ResumeDto(resumeEntity.getId(), resumeEntity.getContext(),resumeEntity.getStudent());
    }

    private ResumeEntity toResumeEntity(ResumeDto resumeDto) {
        if (resumeDto == null)
            return null;
        return new ResumeEntity(resumeDto.getId(), resumeDto.getContext(), null);
    }


    public StudentDto toDto(StudentEntity student){
        return new StudentDto(
                student.getId(),
                student.getStudentName(),
                student.getStudentDept(),
                student.getStudentContactNumber(),
                toResumeDto(student.getResumeEntity())
        );
    }

    public StudentEntity toEntity(StudentDto studentDto){
        StudentEntity student = new StudentEntity();
         student.setId(studentDto.getId());
        student.setStudentName(studentDto.getStudentName());
        student.setStudentDept(studentDto.getStudentDept());
        student.setStudentContactNumber(studentDto.getStudentContactNumber());
        student.setResumeEntity(toResumeEntity(studentDto.getResumeDto()));
        return student;
    }

    public StudentDto save(StudentDto studentDto){
        StudentEntity studentEntity = toEntity(studentDto);
        StudentEntity save = studentRepository.save(studentEntity);
        return toDto(save);
    }


}
