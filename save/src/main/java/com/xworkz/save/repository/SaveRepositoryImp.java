package com.xworkz.save.repository;

import com.xworkz.save.entity.SaveEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SaveRepositoryImp implements SaveRepository {

    @Autowired
    private EntityManagerFactory emf;

    public SaveRepositoryImp() {
        System.out.println("Save Repository initialized");
    }

    // Save a record
    @Override
    public String save(SaveEntity saveEntity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            em.persist(saveEntity);
            et.commit();
            return "Submitted Successfully";
        } catch (Exception e) {
            if (et.isActive()) et.rollback();
            e.printStackTrace();
            return "Submission Failed";
        } finally {
            em.close();
        }
    }

    // Fetch all records
    @Override
    public List<SaveEntity> getAll() {
        EntityManager em = emf.createEntityManager();
        List<SaveEntity> list = new ArrayList<>();
        try {
            TypedQuery<SaveEntity> query = em.createNamedQuery("getAll", SaveEntity.class);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return list;
    }

    // Delete record by userName
    @Override
    public String remove(SaveEntity saveEntity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            Query query = em.createNamedQuery("removeByUserName");
            query.setParameter("userName", saveEntity.getUserName());

            int rowsDeleted = query.executeUpdate();
            et.commit();

            if (rowsDeleted > 0) {
                return "Deleted Successfully";
            } else {
                return "No record found with this name";
            }

        } catch (Exception e) {
            if (et.isActive()) et.rollback();
            e.printStackTrace();
            return "Error while deleting";
        } finally {
            em.close();
        }
    }

    @Override
    public String checkEmailAndNumber(String email, String age) {
        EntityManager em = emf.createEntityManager();
        try{
            Query query = em.createNamedQuery("checkEmailAndNumber");
            query.setParameter("email",email);
            query.setParameter("number",)

        } catch (Exception e) {

        }finally {

        }
        return "";
    }
}
