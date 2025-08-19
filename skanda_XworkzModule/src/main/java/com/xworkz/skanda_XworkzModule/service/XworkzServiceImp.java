package com.xworkz.skanda_XworkzModule.service;
import com.xworkz.skanda_XworkzModule.dto.XworkzDTO;
import com.xworkz.skanda_XworkzModule.entity.XworkzEntity;
import com.xworkz.skanda_XworkzModule.repositry.XworkzRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
public class XworkzServiceImp implements XworkzService {


    @Autowired
    private XworkzRepositry xworkzRepositryImp;


    @Override
    public String save( XworkzDTO xworkzDTO) {
        XworkzEntity xworkz = new XworkzEntity();
        xworkz.setId(xworkz.getId());
        xworkz.setUserName(xworkzDTO.getUserName());
        xworkz.setPhoneNumber(xworkzDTO.getPhoneNumber());
        xworkz.setUserEmail(xworkzDTO.getUserEmail());
        xworkz.setUserAge(xworkzDTO.getUserAge());
        xworkz.setUserPassword(xworkzDTO.getUserPassword());
        xworkz.setUserAdress(xworkzDTO.getUserAdress());
        xworkz.setUserGender(xworkzDTO.getGender());


       return xworkzRepositryImp.save(xworkz);


//            System.out.println("service: "+xworkzDTO);




//        xworkzDTO.setUserName(xworkzDTO.getUserName());
//        xworkzDTO.setPhoneNumber(xworkzDTO.getPhoneNumber());
//        xworkzDTO.setUserEmail(xworkzDTO.getUserEmail());
//        xworkzDTO.setUserAge(xworkzDTO.getUserAge());
//        xworkzDTO.setUserPassword(xworkzDTO.getUserPassword());
//        xworkzDTO.setUserAdress(xworkzDTO.getUserAdress());
//        xworkzDTO.setGender(xworkzDTO.getGender());
//        xworkzRepositryImp.save(xworkz);


    }
}
