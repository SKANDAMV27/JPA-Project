package com.xworkz.skanda_XworkzModule.repositry;

import com.xworkz.skanda_XworkzModule.entity.XworkzEntity;
import org.springframework.beans.factory.annotation.Autowired;
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
    public boolean signInValidation(String name, String email) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        try {
            Query query = manager.createNamedQuery("signInValidation");
            query.setParameter("email", email);
            query.setParameter("name", name);

            Object result = query.getSingleResult();
            return result != null;   // ✅ true if found
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            manager.close();
        }
    }
}