package com.xworkz.save.service;


import com.xworkz.save.dto.SaveDto;
import org.springframework.context.annotation.Bean;

public interface SaveService {


     String save(SaveDto saveDto);
}
