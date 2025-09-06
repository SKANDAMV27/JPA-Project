package com.xworkz.skanda_XworkzModule.repositry;

import com.xworkz.skanda_XworkzModule.entity.XworkzEntity;

public interface XworkzRepositry {
    String save(XworkzEntity xworkz);

    XworkzEntity signInValidation(String email);

    public void updateUser(XworkzEntity user);

    public boolean checKEmail(String email);



//    public XworkzEntity findByEmail(String email);

     public  XworkzEntity otpSend(String email);

     public String delete(XworkzEntity xworkz);
}
