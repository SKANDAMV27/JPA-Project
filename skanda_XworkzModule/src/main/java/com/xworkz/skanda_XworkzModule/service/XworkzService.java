package com.xworkz.skanda_XworkzModule.service;

import com.xworkz.skanda_XworkzModule.dto.EmailDTO;
import com.xworkz.skanda_XworkzModule.dto.XworkzDTO;
import com.xworkz.skanda_XworkzModule.entity.XworkzEntity;

public interface XworkzService {
    String save(XworkzDTO xworkzDTO);

    String signInValidation(String password,String email);

//    public XworkzEntity findByEmail(String email);

    String sendOTP(String email,EmailDTO emailDTO);


}
