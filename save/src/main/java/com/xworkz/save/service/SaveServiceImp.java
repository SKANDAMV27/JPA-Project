package com.xworkz.save.service;

import com.xworkz.save.dto.SaveDto;
import com.xworkz.save.entity.SaveEntity;
import com.xworkz.save.repository.SaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public boolean checkEmailAndNumber(String email, String number) {

        System.out.println("Check The Email And Number Is already in DB are not");

        boolean exist = saveRepository.checkEmailAndNumber(email,number);

        if(exist){
            System.out.println("Save");
        }else{
            System.out.println("Email and Number are already in DB");
        }

        return exist;
    }

    @Override
    public boolean updateTheRow(SaveDto saveDto) {
        System.out.println("Update The Data");

        SaveEntity saveEntity = new SaveEntity();
        saveEntity.setUserName(saveDto.getName());
        saveEntity.setUserEmail(saveDto.getEmail());
        saveEntity.setUserAge(saveDto.getAge());
        saveEntity.setUserNumber(saveDto.getNumber());
//        int updatedRows = saveRepository.updateTheRow();
//        System.out.println("Update...");
//        if (updatedRows > 0) {
//            System.out.println("No Data Found in Data Base");
//            return false;
//
//        } else {
//            System.out.println("Row updated successfully : " + saveDto.getName());
//            return true;
//        }
        return saveRepository.updateTheRow(saveEntity);
    }


}



