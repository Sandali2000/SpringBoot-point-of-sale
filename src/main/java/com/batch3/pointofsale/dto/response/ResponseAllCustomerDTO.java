package com.batch3.pointofsale.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseAllCustomerDTO {
    private String customerName;
    private String customerAddress;
    private double customerSalary;
    private ArrayList contactNumber;
    private String nic;
    private boolean activeState;
}
