package com.xworkz.skanda_XworkzModule.service;

import com.xworkz.skanda_XworkzModule.dto.EmailDTO;
import com.xworkz.skanda_XworkzModule.dto.XworkzDTO;
import com.xworkz.skanda_XworkzModule.entity.XworkzEntity;
import com.xworkz.skanda_XworkzModule.repositry.XworkzRepositry;
//import com.xworkz.skanda_XworkzModule.util.LoginStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Properties;
import java.util.Random;

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
        String result =  xworkzRepositryImp.save(xworkz);

        String email = xworkz.getUserEmail();
        String head = "WelCome To X-WorkZ";
        String body = "Dear "+xworkzDTO.getUserName()+",\n\nThankyou For Regestering"+
                "\n\nName: "+xworkzDTO.getUserName()
                +"\n\nEmail: "+xworkzDTO.getUserEmail()+
                "\n\nPassword: "+xworkzDTO.getUserPassword()+
                "\n\nCity: "+xworkzDTO.getUserAdress()+"\n\n"+"\n\n"
                +"\n\nSkanda M V"+
                "\n\n9353193240"+"" +
                "\n\nskandagowda0@gmail.com";
        sendEmail(email,head,body);

        return result;
    }

    private void sendEmail(String email, String subject, String body) {
        final String username = "skandagowda0@gmail.com";
        final String password = "bhha dilv iqfp lvzm"; // App Password

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
            System.out.println("Email sent successfully to " + email);

        } catch (Exception e) {
            e.printStackTrace();
        }
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

            if (user.getLockTime() != null &&
                    user.getLockTime().plusHours(24).isAfter(LocalDateTime.now())) {
                return "LOCKED"; // still locked
            } else {
                // Unlock after 24 hrs
//                user.setAccountLocked(false);
                user.setFailedAttempts(0);
                user.setLockTime(null);
                xworkzRepositryImp.updateUser(user);
            }


        // 3. Verify password
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(password, user.getUserPassword())) {
            int attempts = user.getFailedAttempts() + 1;
            user.setFailedAttempts(attempts);

            if (attempts >= 3) {
//                user.setAccountLocked(true);
                user.setLockTime(LocalDateTime.now());
                xworkzRepositryImp.updateUser(user);
                return "LOCKED_NOW";
            }

            xworkzRepositryImp.updateUser(user);
            return "INVALID_PASSWORD";
        }

        // 4. Reset login status if successful
        user.setFailedAttempts(0);
//        user.setAccountLocked(false);
        user.setLockTime(null);
        xworkzRepositryImp.updateUser(user);

        return "SUCCESS";
    }

    @Override
    public String sendOTP(String email,EmailDTO emailDTO) {
        System.out.println("Send OTP Service");
        XworkzEntity user =  xworkzRepositryImp.otpSend(email);
        System.out.println(user);

        if(user==null){
            System.out.println("Email Id Not Found");
            return "Email Not Found";
        }


        Random random = new Random();
        String otp = String.valueOf(100000 + random.nextInt(900000));
        user.setOtpcode(otp);
        user.setOtpTime(LocalTime.from(LocalDateTime.now().plusMinutes(5)));
        xworkzRepositryImp.updateUser(user);


        String otpEmail = emailDTO.getEmail();
        String head = "X-WorkZ OTP Verification";
        String body = "Dear "+emailDTO.getName()+",\n\nYour OTP Code:"+otp+"\n\nRegards,\n\nSkanda M V\n\n9353193240\n\nskandagowda0@gmail.com";
        sendEmail(otpEmail,head,body);

        return "One Time Password Send Successfully To: "+emailDTO.getEmail();

    }

    @Override
    public String delete(XworkzDTO xworkzDTO) {

        System.out.println("Delete Service");
        XworkzEntity xworkzEntity = new XworkzEntity();
        String result = xworkzRepositryImp.delete(xworkzDTO.getUserEmail());
        System.out.println(result);
        System.out.println("Delete Email: "+xworkzDTO.getUserEmail());

        String deleteEmail = xworkzDTO.getUserEmail();
        String head = "Account Deletion Confirmation";
        String body = "Dear "+xworkzDTO.getUserName()+",\n\nThankyou For Deleting The Account";
        sendEmail(deleteEmail,head,body);
        return result;

    }

    @Override
    public String verifyOTP(String email, String OTP) {
        return "";
    }


}
