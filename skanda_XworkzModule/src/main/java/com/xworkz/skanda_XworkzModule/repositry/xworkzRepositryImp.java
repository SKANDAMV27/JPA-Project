package com.xworkz.skanda_XworkzModule.repositry;

import com.xworkz.skanda_XworkzModule.entity.xworkzEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class xworkzRepositryImp implements xworkzRepositry{
    @Override
    public void save(List<xworkzEntity> list) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        try{
            Persistence.createEntityManagerFactory("xworkz");
            emf.createEntityManager();
            em.getTransaction();
            et.begin();
            for(xworkzEntity xworkz :list){
                em.persist(xworkz);
            }
            et.commit();
        } catch (Exception e) {
            if(et.isActive()){
                et.rollback();
            }
        }finally {
            em.close();
        }

    }
}
