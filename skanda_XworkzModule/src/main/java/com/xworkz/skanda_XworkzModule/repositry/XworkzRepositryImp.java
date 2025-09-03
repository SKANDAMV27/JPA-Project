package com.xworkz.skanda_XworkzModule.repositry;

import com.xworkz.skanda_XworkzModule.entity.XworkzEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class XworkzRepositryImp implements XworkzRepositry {

//    EntityManagerFactory emf =  Persistence.createEntityManagerFactory("X-workZ");

    @Autowired
    private EntityManagerFactory entityManagerFactory;//= Persistence.createEntityManagerFactory("X-workZ");

    @Override
    public String save(XworkzEntity xworkz) {
        System.out.println("Saving user: " + xworkz.getUserName());

        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            // Encode password
            BCryptPasswordEncoder encoder  = new BCryptPasswordEncoder();
            String password = encoder.encode(xworkz.getUserPassword());
            xworkz.setUserPassword(password);

            em.persist(xworkz);
            et.commit();

            System.out.println("Saved successfully: " + xworkz.getUserEmail());
            return "Data has been submitted";

        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
            return "not saved";
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }



    @Override
    public boolean signInValidation(String email, String password) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        System.out.println("Repo: SignIn Validation...");

        try {
            Query query = manager.createQuery(
                    "SELECT e.userPassword FROM XworkzEntity e WHERE e.userEmail = :email"
            );
            query.setParameter("email", email);

            String dbPassword = (String) query.getSingleResult(); // hashed password
            if (dbPassword != null) {
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                return encoder.matches(password, dbPassword);
            }
        } catch (Exception e) {
            System.out.println("Error during signInValidation: " + e.getMessage());
            return false;
        } finally {
            manager.close();
        }
        return false;
    }




    @Override
    public boolean checKEmail(String email) {
        System.out.println("Check if the Email is present in Data Base" + email);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {

            Query query = entityManager.createNamedQuery("emailOPT");
            query.setParameter("email", email);
            Long count = (Long) query.getSingleResult();


            return count > 0;

        } catch (Exception e) {
            return false;
        }finally {
            entityManager.close();
        }


    }
//
//    @Override
//    public boolean otpSend(String email) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        try{
//            Query query = entityManager.createNamedQuery("otpSend");
//            query.setParameter("email",email);
//            XworkzEntity xworkz = (XworkzEntity) query.getSingleResult();
//            return
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return false;
//    }
}