package com.xworkz.skanda_XworkzModule.service;

import com.xworkz.skanda_XworkzModule.entity.xworkzEntity;
import com.xworkz.skanda_XworkzModule.repositry.xworkzRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class xworkzServiceImp implements xworkzService {

    @Autowired
    private xworkzRepositry xworkzRepositry;

    @Override
    public void save(xworkzEntity xworkzEntity) {
        xworkzRepositry.save((List<xworkzEntity>) xworkzEntity);
    }
}
