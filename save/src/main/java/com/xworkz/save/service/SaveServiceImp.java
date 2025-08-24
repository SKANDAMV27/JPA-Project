package com.xworkz.save.service;

import com.xworkz.save.dto.SaveDto;
import com.xworkz.save.entity.SaveEntity;
import com.xworkz.save.repository.SaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SaveServiceImp implements SaveService{
    public SaveServiceImp() {
        System.out.println("no args of Service...☺");
    }

    @Autowired
        public SaveRepository saveRepository;

    @Override
    public String save(SaveDto saveDto) {
        System.out.println("Service Layer");

        SaveEntity saveEntity = new SaveEntity();

        System.out.println("Service Add");
        saveEntity.setUserName(saveDto.getName());
        saveEntity.setUserNumber(saveDto.getNumber());
        saveEntity.setUserEmail(saveDto.getEmail());
        saveEntity.setUserAge(saveDto.getAge());

        return saveRepository.save(saveEntity);
    }


    //This is For The Display  The Full Table
    @Override
    public List<SaveEntity> getAll() {
        System.out.println("Service Get All Method");


//        SaveEntity saveEntity = new SaveEntity();
            return saveRepository.getAll();
    }

    // This is remove the Column Based On the id

    @Override
    public String delete(SaveDto saveDto) {
        System.out.println("Delete The Coloumn Based On The Id");
        SaveEntity saveEntity = new SaveEntity();
        saveEntity.setUserName((saveDto.getName()));

        return saveRepository.remove(saveEntity);
    }






}
