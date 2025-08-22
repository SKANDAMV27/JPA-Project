package com.xworkz.skanda_XworkzModule.repositry;

import com.xworkz.skanda_XworkzModule.entity.XworkzEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class XworkzRepositryImp implements XworkzRepositry {

//    EntityManagerFactory emf =  Persistence.createEntityManagerFactory("X-workZ");

    @Autowired
    private EntityManagerFactory entityManagerFactory;//= Persistence.createEntityManagerFactory("X-workZ");

    @Override
    public String save(XworkzEntity xworkz) {

        System.out.println(xworkz.getUserName());

        System.out.println("X-WorkZ Repositry");
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();
        ;
        try {
            et.begin();
            BCryptPasswordEncoder encoder  = new BCryptPasswordEncoder();   //First Create an Object
            String password= encoder.encode(xworkz.getUserPassword());      // Take a Plain text Entered By the user and convert to hash password having 60+ characture String.
            xworkz.setUserPassword(password);   //Replace the Plaintext Password to hashed password with 60+ characture String.
            em.persist(xworkz);

            et.commit();
            return "Data has been submitted";
        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return "not saved";
    }

    @Override
    public boolean signInValidation(String password, String email) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        System.out.println("Xworkz Repo...");

        try {
            Query query = manager.createQuery(
                    "SELECT e.userPassword FROM XworkzEntity e WHERE e.userEmail = :email"
            );
            query.setParameter("email", email);

            String dbPassword = (String) query.getSingleResult(); // Hashed password

            if (dbPassword != null) {
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                return encoder.matches(password, dbPassword); // Compare plain vs hashed
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