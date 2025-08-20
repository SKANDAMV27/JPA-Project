package com.xworkz.save.repository;

import com.xworkz.save.entity.SaveEntity;

import java.util.List;

public interface SaveRepository {

    String save(SaveEntity saveEntity);

    List<SaveEntity> getAll();
}
