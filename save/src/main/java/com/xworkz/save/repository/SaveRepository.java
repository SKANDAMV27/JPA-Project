package com.xworkz.save.repository;

import com.xworkz.save.entity.SaveEntity;

import java.util.List;

public interface SaveRepository {

    String save(SaveEntity saveEntity);

     List<SaveEntity> getAll();

     String remove(SaveEntity saveEntity);

    boolean checkEmailAndNumber(String email,String number);

    int updateTheRow(String email,String number,int age);

}
