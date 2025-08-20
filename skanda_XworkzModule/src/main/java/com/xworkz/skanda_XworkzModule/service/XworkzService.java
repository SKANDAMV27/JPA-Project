package com.xworkz.skanda_XworkzModule.service;

import com.xworkz.skanda_XworkzModule.dto.XworkzDTO;
import org.springframework.validation.BindingResult;

public interface XworkzService {
    String save(XworkzDTO xworkzDTO);

    boolean signInValidation(String password,String email);
}
