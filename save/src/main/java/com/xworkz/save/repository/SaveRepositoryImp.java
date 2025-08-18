package com.xworkz.save.repository;

import com.xworkz.save.entity.SaveEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveRepositoryImp implements SaveRepository{



    @Autowired
    public EntityManagerFactory emf = Persistence.createEntityManagerFactory("save");

    @Override
    public boolean save(SaveEntity saveEntity) {

        System.out.println("Save Repository Implemination");

        EntityManager em = null;
        EntityTransaction et = null;
        try{
            emf.createEntityManager();
            em.getTransaction();
            et.begin();

            em.persist(saveEntity);

            et.commit();

        } catch (Exception e) {
            if(et!=null && et.isActive()){
                et.rollback();
            }
        }finally {
            if(em!=null){
                em.close();
            }

        }

        return false;
    }
}
