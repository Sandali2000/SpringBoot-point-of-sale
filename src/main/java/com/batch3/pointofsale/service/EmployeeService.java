package com.batch3.pointofsale.service;

import com.batch3.pointofsale.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService  {

    String addEmployee(EmployeeDTO employeeDTO);

    String updateEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(int employeeId);


    List<EmployeeDTO> getAllEmployee();

    String deleteEmployee(int employeeId);

    List<EmployeeDTO> getEmployeeByName(String name);
}
