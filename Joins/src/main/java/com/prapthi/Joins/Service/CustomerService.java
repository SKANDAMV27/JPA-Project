package com.prapthi.Joins.Service;

import com.prapthi.Joins.Dto.CustomerDTO;
import com.prapthi.Joins.Dto.OrderDTO;
import com.prapthi.Joins.Model.CustomerEntity;
import com.prapthi.Joins.Model.OrderEntity;
import com.prapthi.Joins.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerDTO toCustomerDTO(CustomerEntity customerEntity){
        if(customerEntity==null){
            return null;
        }
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customerEntity.getId());
        customerDTO.setCustomerName(customerEntity.getCustomerName());
        customerDTO.setCustomerAddress(customerEntity.getCustomerAddress());
        if(customerEntity.getOrderEntityList()!=null){
            List<OrderDTO> customerDTOList = customerEntity.getOrderEntityList()
                    .stream()
                    .map(this::toOrderDto)
                    .collect(Collectors.toList());

            customerDTO.setOrderDTOList(customerDTOList);
        }
        return customerDTO;
    }

    public OrderDTO toOrderDto(OrderEntity orderEntity)

}
