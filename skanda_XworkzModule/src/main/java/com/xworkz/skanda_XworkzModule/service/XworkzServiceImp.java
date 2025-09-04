package com.xworkz.skanda_XworkzModule.service;

import com.xworkz.skanda_XworkzModule.dto.XworkzDTO;
import com.xworkz.skanda_XworkzModule.entity.XworkzEntity;
import com.xworkz.skanda_XworkzModule.repositry.XworkzRepositry;
//import com.xworkz.skanda_XworkzModule.util.LoginStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class XworkzServiceImp implements XworkzService {

    @Autowired
    private XworkzRepositry xworkzRepositryImp;

    @Override
    public String save(XworkzDTO xworkzDTO) {
        XworkzEntity xworkz = new XworkzEntity();
        xworkz.setUserName(xworkzDTO.getUserName());
        xworkz.setPhoneNumber(xworkzDTO.getPhoneNumber());
        xworkz.setUserEmail(xworkzDTO.getUserEmail());
        xworkz.setUserAge(xworkzDTO.getUserAge());
        xworkz.setUserPassword(xworkzDTO.getUserPassword()); // plain before encoding
        xworkz.setUserAdress(xworkzDTO.getUserAdress());
        xworkz.setUserGender(xworkzDTO.getGender());

        return xworkzRepositryImp.save(xworkz);
    }

    @Override
    public String signInValidation(String email, String password) {
        System.out.println("Service: SignIn Validation");

        // 1. Check if email exists
        XworkzEntity user = xworkzRepositryImp.signInValidation(email);

        if (user == null) {
            return "INVALID_EMAIL";
        }

        // 2. Check if account is locked
        if (user.isAccountLocked()) {
            if (user.getLockTime() != null &&
                    user.getLockTime().plusHours(24).isAfter(LocalDateTime.now())) {
                return "LOCKED"; // still locked
            } else {
                // Unlock after 24 hrs
                user.setAccountLocked(false);
                user.setFailedAttempts(0);
                user.setLockTime(null);
                xworkzRepositryImp.updateUser(user);
            }
        }

        // 3. Verify password
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(password, user.getUserPassword())) {
            int attempts = user.getFailedAttempts() + 1;
            user.setFailedAttempts(attempts);

            if (attempts >= 3) {
                user.setAccountLocked(true);
                user.setLockTime(LocalDateTime.now());
                xworkzRepositryImp.updateUser(user);
                return "LOCKED_NOW";
            }

            xworkzRepositryImp.updateUser(user);
            return "INVALID_PASSWORD";
        }

        // 4. Reset login status if successful
        user.setFailedAttempts(0);
        user.setAccountLocked(false);
        user.setLockTime(null);
        xworkzRepositryImp.updateUser(user);

        return "SUCCESS";
    }
}
