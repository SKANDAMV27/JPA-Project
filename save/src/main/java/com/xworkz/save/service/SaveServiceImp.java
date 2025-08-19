package com.xworkz.save.service;

import com.xworkz.save.dto.SaveDto;
import com.xworkz.save.entity.SaveEntity;
import com.xworkz.save.repository.SaveRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SaveServiceImp implements SaveService{

        @Autowired
        public SaveRepository saveRepository;

    @Override
    public String save(SaveDto saveDto) {
        System.out.println("Service Layer");

        SaveEntity saveEntity = new SaveEntity();

        System.out.println("Service Add");
        saveEntity.setUserName(saveDto.getName());
        saveEntity.setUsreNumber(saveDto.getNumber());
        saveEntity.setUserEmail(saveDto.getEmail());
        saveEntity.setUserAge(saveDto.getAge());

        return saveRepository.save(saveEntity);
    }
}
