package com.xworkz.skanda_XworkzModule.service;
import com.xworkz.skanda_XworkzModule.dto.XworkzDTO;
import com.xworkz.skanda_XworkzModule.entity.XworkzEntity;
import com.xworkz.skanda_XworkzModule.repositry.XworkzRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;
import java.util.List;
import java.util.Properties;

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

    @Override
    public boolean signInValidation(String password, String email) {
        System.out.println("...SignIn Validation...");
        return xworkzRepositryImp.signInValidation(password, email);
    }

    private void getEmail(String email,String subject,String body){


        final String username = "skandagowda0@gmail.com";
        final String password = "bhha dilv iqfp lvzm";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
