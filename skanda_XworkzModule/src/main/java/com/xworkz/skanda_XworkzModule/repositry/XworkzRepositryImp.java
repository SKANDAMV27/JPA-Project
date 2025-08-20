package com.xworkz.skanda_XworkzModule.repositry;

import com.xworkz.skanda_XworkzModule.entity.XworkzEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

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

           Query query = manager.createQuery("signInValidation");
            String entity = (String) query.getSingleResult();

            if(entity!=null){
                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
                return bCryptPasswordEncoder.matches(password, entity);
            }

        } catch (Exception e) {
            return false;

        } finally {
            manager.close();
        }
        return true;
    }
}