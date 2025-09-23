package com.prapthi.CRUD_OneToOne.service;

import com.prapthi.CRUD_OneToOne.dto.ResumeDto;
import com.prapthi.CRUD_OneToOne.entity.ResumeEntity;
import com.prapthi.CRUD_OneToOne.repositry.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    public ResumeDto resumeDto(ResumeEntity resumeEntity){
        if(resumeEntity==null){
            return null;
        }
        return resumeDto(resumeEntity.getStudent().getResumeEntity());
    }

    public ResumeEntity resumeEntity(ResumeDto resumeDto){
        if(resumeDto==null){
            return null;
        }
        return new ResumeEntity(resumeDto.getId(), resumeDto.getContext(),resumeDto.getStudent());
    }

    public ResumeDto toDto(ResumeEntity resumeEntity){
        return new ResumeDto(resumeEntity.getId(),
                resumeEntity.getContext(),
                resumeDto(resumeEntity.getStudent().getResumeEntity()).getStudent());
    }

    public ResumeEntity toEntity(ResumeDto resumeDto){
        ResumeEntity resumeEntity = new ResumeEntity();
        resumeEntity.setId(resumeDto.getId());
        resumeEntity.setContext(resumeDto.getContext());
        resumeEntity.setStudent(resumeDto.getStudent());
        return resumeEntity;
    }

    public ResumeDto save(ResumeDto resumeDto){
               ResumeEntity resumeEntity = toEntity(resumeDto);
               ResumeEntity save = resumeRepository.save(resumeEntity);
               return toDto(save);
    }
}

