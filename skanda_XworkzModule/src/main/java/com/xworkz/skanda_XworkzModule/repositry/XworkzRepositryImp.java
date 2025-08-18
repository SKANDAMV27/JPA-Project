package com.xworkz.skanda_XworkzModule.repositry;

import com.xworkz.skanda_XworkzModule.entity.XworkzEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Repository
public class XworkzRepositryImp implements XworkzRepositry {

//    EntityManagerFactory emf =  Persistence.createEntityManagerFactory("X-workZ");

    @Autowired
    EntityManagerFactory emf;

    @Override
    public void save(XworkzEntity xworkz) {

        System.out.println("X-WorkZ Repositry");

        EntityManager em = null;
        EntityTransaction et = null;
        try{

           em= emf.createEntityManager();
           et = em.getTransaction();
            et.begin();

                em.persist(xworkz);

            et.commit();
        } catch (Exception e) {
            if(e!=null && et.isActive()){
                et.rollback();
            }
        }finally {
            if (em != null) {
                em.close();
            }
        }

    }
}
