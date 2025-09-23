package com.prapthi.CRUD_OneToOne.service;

import com.prapthi.CRUD_OneToOne.dto.ResumeDto;
import com.prapthi.CRUD_OneToOne.dto.StudentDto;
import com.prapthi.CRUD_OneToOne.entity.ResumeEntity;
import com.prapthi.CRUD_OneToOne.entity.StudentEntity;
import com.prapthi.CRUD_OneToOne.repositry.ResumeRepository;
import com.prapthi.CRUD_OneToOne.repositry.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private StudentRepository studentRepository;

    public ResumeEntity toEntity(ResumeDto resumeDto) {
        ResumeEntity resumeEntity = new ResumeEntity();
        resumeEntity.setId(resumeDto.getId());
        resumeEntity.setContext(resumeDto.getContext());

        if (resumeDto.getStudentId() != null) {
            StudentEntity student = studentRepository.findById(resumeDto.getStudentId())
                    .orElseThrow(() -> new RuntimeException("Student not found with id: " + resumeDto.getStudentId()));
            resumeEntity.setStudent(student);
        }
        return resumeEntity;
    }

    private StudentDto toStudentDto(StudentEntity student) {
        if (student == null) return null;
        StudentDto dto = new StudentDto();
        dto.setId(student.getId());
        dto.setStudentName(student.getStudentName());
        dto.setStudentDept(student.getStudentDept());
        dto.setStudentContactNumber(student.getStudentContactNumber());
        return dto;
    }

    public ResumeDto toDto(ResumeEntity resumeEntity) {
        ResumeDto dto = new ResumeDto();
        dto.setId(resumeEntity.getId());
        dto.setContext(resumeEntity.getContext());

        if (resumeEntity.getStudent() != null) {
            dto.setStudentId(resumeEntity.getStudent().getId());
            dto.setStudentId(toStudentDto(resumeEntity.getStudent()).getId()); // <-- full Student data
        }
        return dto;
    }


    public ResumeDto save(ResumeDto resumeDto) {
        ResumeEntity resumeEntity = toEntity(resumeDto);
        ResumeEntity saved = resumeRepository.save(resumeEntity);
        return toDto(saved);
    }


    public List<ResumeDto> readAll() {
        List<ResumeEntity> readAll = resumeRepository.findAll();
        System.out.println("All Resume + Student Data Read");
        return readAll.stream().map(this::toDto).collect(Collectors.toList());
    }


    public ResumeDto readById(long id) {
        System.out.println("Read Resume + Student Data by Id");
        return resumeRepository.findById(id).map(this::toDto).orElse(null);
    }
}
