package com.prapthi.CRUD_OneToOne.service;

import com.prapthi.CRUD_OneToOne.dto.ResumeDto;
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

    // Convert DTO -> Entity
    public ResumeEntity toEntity(ResumeDto resumeDto){
        ResumeEntity resumeEntity = new ResumeEntity();
        resumeEntity.setId(resumeDto.getId());
        resumeEntity.setContext(resumeDto.getContext());

        if(resumeDto.getStudentId() != null){
            StudentEntity student = studentRepository.findById(resumeDto.getStudentId())
                    .orElseThrow(() -> new RuntimeException("Student not found with id: " + resumeDto.getStudentId()));
            resumeEntity.setStudent(student);
        }

        return resumeEntity;
    }

    // Convert Entity -> DTO
    public ResumeDto toDto(ResumeEntity resumeEntity){
        ResumeDto dto = new ResumeDto();
        dto.setId(resumeEntity.getId());
        dto.setContext(resumeEntity.getContext());

        if(resumeEntity.getStudent() != null){
            dto.setStudentId(resumeEntity.getStudent().getId());
        }

        return dto;
    }

    // Save Resume
    public ResumeDto save(ResumeDto resumeDto){
        ResumeEntity resumeEntity = toEntity(resumeDto);
        ResumeEntity saved = resumeRepository.save(resumeEntity);
        return toDto(saved);
    }

    public List<ResumeDto> readAll(){
         List<ResumeEntity> readAll = resumeRepository.findAll();
        System.out.println("ALl The Data Read");
         return readAll.stream().map(this::toDto).collect(Collectors.toList());
    }
}
