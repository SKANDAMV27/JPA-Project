package com.prapthi.Joins.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private int id;

    private String orderName;

    private List<CustomerDTO> customerDTOList;
}
