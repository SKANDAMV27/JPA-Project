package com.xworkz.save.service;


import com.xworkz.save.dto.SaveDto;
import com.xworkz.save.entity.SaveEntity;

import java.util.List;


public interface SaveService {


     String save(SaveDto saveDto);

     List<SaveEntity> getAll();
}
