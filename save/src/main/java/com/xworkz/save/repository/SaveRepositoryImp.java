package com.xworkz.save.repository;

import com.xworkz.save.entity.SaveEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveRepositoryImp implements SaveRepository{



    @Autowired
    public EntityManagerFactory emf; //= Persistence.createEntityManagerFactory("save");

    @Override
    public String save(SaveEntity saveEntity) {

        System.out.println(saveEntity.getUserName());

        System.out.println("Save Repository Implemination");

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try{

            et.begin();

            em.persist(saveEntity);

            et.commit();

        } catch (Exception e) {
            if(et!=null && et.isActive()){
                et.rollback();
                return "Not Submitted";
            }
        }finally {
            if(em!=null){
                em.close();
            }

        }

        return "Submitted";
    }
}
