package com.xworkz.skanda_XworkzModule.service;

import com.xworkz.skanda_XworkzModule.dto.XworkzDTO;
import com.xworkz.skanda_XworkzModule.entity.XworkzEntity;
import com.xworkz.skanda_XworkzModule.repositry.XworkzRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.Properties;

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
        xworkz.setUserPassword(xworkzDTO.getUserPassword()); // plain password
        xworkz.setUserAdress(xworkzDTO.getUserAdress());
        xworkz.setUserGender(xworkzDTO.getGender());

        // Save to database
        String result = xworkzRepositryImp.save(xworkz);

        if ("not saved".equals(result)) {
            return "Registration failed!";
        }

        // Send email after successful save
        String email = xworkzDTO.getUserEmail();
        String subject = "Welcome To X-WorkZ";
        String body = "Hi " + xworkzDTO.getUserName()
                + ",\n\nThank you for registering at X-WorkZ.\n\n- Skanda M V\nThirthahalli";

        sendEmail(email, subject, body);

        return result;
    }


    // Method for sending email
    private void sendEmail(String email, String subject, String body) {
        final String username = "skandagowda0@gmail.com";
        final String password = "bhha dilv iqfp lvzm"; // App password

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); // TLS

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
            System.out.println("Email sent successfully to " + email);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean signInValidation(String email, String password) {
        System.out.println("Service: SignIn Validation");
        return xworkzRepositryImp.signInValidation(email, password);
    }




}
