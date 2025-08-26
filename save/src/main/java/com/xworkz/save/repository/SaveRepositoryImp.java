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

    //This is to Check If Email And Phone is already Is in db are not
    @Override
    public boolean checkEmailAndNumber(String email, String number) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try{
            Query query = em.createNamedQuery("checkEmailAndNumber");
            query.setParameter("userEmail",email);
            query.setParameter("userNumber",number);

//            /String check = query.getSingleResult().toString();

            Long count = (Long) query.getSingleResult();
            return count>0;

        } catch (Exception e) {
            if(et!=null && et.isActive()){
                et.rollback();
            }
        }
        finally {
            em.close();

        }
        return false;

    }

    //THis is for Update
    @Override
    public boolean updateTheRow(SaveEntity saveEntity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
//            Query query = em.createNamedQuery("updateTheRow");
//            query.setParameter("email", email);
//            query.setParameter("number", number);
//            query.setParameter("age", age);
//            query.setParameter("name",name);
//            int rows = query.executeUpdate();
            em.merge(saveEntity);

            tx.commit();
            return true;
//            return rows;
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
        return false;
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


}
