package com.xworkz.save.repository;

import com.xworkz.save.entity.SaveEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class SaveRepositoryImp implements SaveRepository{



    @Autowired
    public EntityManagerFactory emf;

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

    @Override
    public List<SaveEntity> getAll() {

        System.out.println(".....Get All Data....");

        List<SaveEntity> list = new ArrayList<>();

        EntityManager entityManager =  emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {

            entityTransaction.begin();

            Query query = (Query) entityManager.createNamedQuery("getAll");





            entityTransaction.commit();




        } catch (Exception e) {

        }
        return ;
    }
}
