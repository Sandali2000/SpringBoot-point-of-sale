package com.batch3.pointofsale.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {
    private int employeeId;
    private String employeeName;
    private String employeeAddress;
    private String email;
    private ArrayList contactNumber;
    private String nic;
    private String position;
    private boolean activeState;


}