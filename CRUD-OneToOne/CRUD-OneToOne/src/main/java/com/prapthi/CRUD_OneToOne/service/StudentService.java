package com.prapthi.CRUD_OneToOne.service;

import com.prapthi.CRUD_OneToOne.dto.ResumeDto;
import com.prapthi.CRUD_OneToOne.dto.StudentDto;
import com.prapthi.CRUD_OneToOne.entity.ResumeEntity;
import com.prapthi.CRUD_OneToOne.entity.StudentEntity;
import com.prapthi.CRUD_OneToOne.repositry.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        dto.setStudentId(resume.getStudent() != null ? resume.getStudent().getId() : null);
        return dto;
    }

    private ResumeEntity toResumeEntity(ResumeDto resumeDto){
        if(resumeDto == null)
            return null;
        ResumeEntity resume = new ResumeEntity();
        resume.setId(resumeDto.getId());
        resume.setContext(resumeDto.getContext());

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

        ResumeEntity resume = toResumeEntity(studentDto.getResumeDto());
        if(resume != null){
            resume.setStudent(student);
            student.setResumeEntity(resume);
        }

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

    public StudentDto getById(long id,StudentDto studentDto){
        System.out.println("Update by Id");
        return  studentRepository.findById(id).map(this::toDto).orElse(null);
    }

    public boolean deleteById(long id) {
        System.out.println("Delete By Id");

        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public StudentDto updateById(long id, StudentDto studentDto) {
        System.out.println("Update By Id");
        return studentRepository.findById(id).map(exist -> {
            if (studentDto.getStudentName() != null) {
                exist.setStudentName(studentDto.getStudentName());
            }
            if (studentDto.getStudentDept() != null) {
                exist.setStudentDept(studentDto.getStudentDept());
            }
            if (studentDto.getStudentContactNumber() != null) {
                exist.setStudentContactNumber(studentDto.getStudentContactNumber());
            }
            if (studentDto.getResumeDto() != null) {
                ResumeEntity resume = exist.getResumeEntity();
                if (resume == null) {
                    resume = new ResumeEntity();
                    resume.setStudent(exist);
                }
                resume.setContext(studentDto.getResumeDto().getContext());
                exist.setResumeEntity(resume);
            }
            StudentEntity updated = studentRepository.save(exist);
            return toDto(updated);
        }).orElse(null);
    }

}
