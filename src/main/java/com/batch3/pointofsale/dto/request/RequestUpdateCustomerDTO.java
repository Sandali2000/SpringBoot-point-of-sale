package com.batch3.pointofsale.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestUpdateCustomerDTO {

    private String customerName;
    private String customerAddress;
    private double customerSalary;




}
