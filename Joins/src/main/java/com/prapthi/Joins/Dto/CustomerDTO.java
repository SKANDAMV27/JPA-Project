package com.prapthi.Joins.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private int id;

    private String customerName;

    private String customerAddress;

    private List<OrderDTO> orderDTOList;
}
