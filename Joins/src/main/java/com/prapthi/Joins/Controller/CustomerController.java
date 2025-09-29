package com.prapthi.Joins.Controller;

import com.prapthi.Joins.Model.CustomerEntity;
import com.prapthi.Joins.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/getAll")
    private List<CustomerEntity> findAllTheData(){
        System.out.println("Find All The Data");
        return customerService.findAll();
    }
}
