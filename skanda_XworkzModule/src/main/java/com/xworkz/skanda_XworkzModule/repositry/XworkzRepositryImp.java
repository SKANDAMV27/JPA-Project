package com.xworkz.skanda_XworkzModule.repositry;

import com.xworkz.skanda_XworkzModule.entity.XworkzEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class XworkzRepositryImp implements XworkzRepositry {

//    EntityManagerFactory emf =  Persistence.createEntityManagerFactory("X-workZ");

    @Autowired
    private EntityManagerFactory entityManagerFactory;//= Persistence.createEntityManagerFactory("X-workZ");

    @Override
    public String save(XworkzEntity xworkz) {
        System.out.println("Saving user: " + xworkz.getUserName());

        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            // Encode password
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String password = encoder.encode(xworkz.getUserPassword());
            xworkz.setUserPassword(password);

            em.persist(xworkz);
            et.commit();

            System.out.println("Saved successfully: " + xworkz.getUserEmail());
            return "Data has been submitted";

        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
            return "not saved";
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }


    @Override
    public XworkzEntity signInValidation(String email) {
        System.out.println("Repo: SignIn Validation...");
        EntityManager manager = entityManagerFactory.createEntityManager();
        System.out.println("It Not Enter To The Try");

        try {
            System.out.println("Enter To The Try");
            Query query = manager.createNamedQuery("emailValidiation");
            query.setParameter("email", email);
            System.out.println("Before The Return");
            return (XworkzEntity) query.getSingleResult();

        }
        catch (NoResultException e) {
            System.out.println("No user found with email: " + email);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            manager.close();
        }
    }




    @Override
    public void updateUser(XworkzEntity user) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            manager.merge(user); // merge updates existing entity
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            System.out.println("Error updating user: " + e.getMessage());
        } finally {
            manager.close();
        }
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
    @Override
    public XworkzEntity otpSend(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            Query query = entityManager.createNamedQuery("otpSend");
            query.setParameter("email",email);
            XworkzEntity xworkz = (XworkzEntity) query.getSingleResult();
            System.out.println(xworkz);
            return xworkz;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            entityManager.close();
        }

    }

    @Override
    public String delete(String email) {
        System.out.println("Delete Repository");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try{
            entityTransaction.begin();
            Query query = entityManager.createNamedQuery("deleteAccount");
            query.setParameter("email",email);
            int result = query.executeUpdate();
            entityTransaction.commit();
            if(result>0){
                return "Account Is Deleted";
            }
            return "Account Not Be Deleted";

        } catch (Exception e) {
            if(entityTransaction.isActive()){
                entityTransaction.rollback();
                System.out.println("Error In deleting");
            }
            throw new RuntimeException(e);
        }
        finally {
            entityManager.close();
        }

    }

    @Override
    public String verifyOTP(String email, String otp) {
        return "";
    }
}