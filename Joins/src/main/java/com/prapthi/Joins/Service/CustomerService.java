package com.prapthi.Joins.Service;


import com.prapthi.Joins.Dto.CustomerDTO;
import com.prapthi.Joins.Model.CustomerEntity;
import com.prapthi.Joins.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerEntity> findAll(){
        System.out.println("Find All The Data");
        return customerRepository.findAll();
    }


}
