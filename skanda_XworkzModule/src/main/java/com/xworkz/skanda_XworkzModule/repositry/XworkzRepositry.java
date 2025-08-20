package com.xworkz.skanda_XworkzModule.repositry;

import com.xworkz.skanda_XworkzModule.entity.XworkzEntity;

public interface XworkzRepositry {
    String save(XworkzEntity xworkz);

    boolean signInValidation(String name,String email);
}
