package com.prapthi.Joins.Repository;

import com.prapthi.Joins.Model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Integer> {


    @Override
    @Query("select c.customerName s.orderName from CustomerEntity c OrderDTO o where c.customerId=s.customerId")
    List<CustomerEntity> findAll();
}
