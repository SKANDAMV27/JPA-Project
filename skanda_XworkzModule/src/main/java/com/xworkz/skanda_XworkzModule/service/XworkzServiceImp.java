package com.xworkz.skanda_XworkzModule.service;

import com.xworkz.skanda_XworkzModule.dto.XworkzDTO;
import com.xworkz.skanda_XworkzModule.entity.XworkzEntity;
import com.xworkz.skanda_XworkzModule.repositry.XworkzRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class XworkzServiceImp implements XworkzService {


    @Autowired
    private XworkzRepositry xworkzRepositryImp;


    @Override
    public void save(XworkzDTO xworkzDTO) {

        XworkzEntity xworkz = new XworkzEntity();
        System.out.println("Service Layer");
        System.out.println("service: "+xworkzDTO);


        xworkzDTO.setUserName(xworkzDTO.getUserName());
        xworkzDTO.setPhoneNumber(xworkzDTO.getPhoneNumber());
        xworkzDTO.setUserEmail(xworkzDTO.getUserEmail());
        xworkzDTO.setUserAge(xworkzDTO.getUserAge());
        xworkzDTO.setUserPassword(xworkzDTO.getUserPassword());
        xworkzDTO.setUserAdress(xworkzDTO.getUserAdress());
        xworkzDTO.setGender(xworkzDTO.getGender());
        xworkzRepositryImp.save(xworkz);



    }
}
