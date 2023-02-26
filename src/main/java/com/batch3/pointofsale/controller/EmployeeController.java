package com.batch3.pointofsale.controller;

import com.batch3.pointofsale.dto.EmployeeDTO;
import com.batch3.pointofsale.entity.Employee;
import com.batch3.pointofsale.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService EmployeeService;

    @PostMapping (path = "/save")

    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        String id= EmployeeService.addEmployee(employeeDTO);
        return id;
    }
    @PutMapping(path = "/update")
    public String updateEmployee(@RequestBody EmployeeDTO employeeDTO){
        String update=EmployeeService.updateEmployee(employeeDTO);
        return update;
    }

    @GetMapping(path = "get-by-id", params = "id")
    public EmployeeDTO getEmployeeById(@RequestParam (value = "id")int employeeId){
      return   EmployeeService.getEmployeeById(employeeId);
    }

    @GetMapping(path = "get-all-employee")
    public List<EmployeeDTO> getAllEmployee(){
        List <EmployeeDTO> allEmployee= EmployeeService.getAllEmployee();
        return allEmployee;
    }
    @DeleteMapping(path = "/delete/{id}")
    public String deleteEmployee(@PathVariable(value = "id")int employeeId){
        String delete=EmployeeService.deleteEmployee(employeeId);
        return delete;
    }
    @GetMapping(path="/get-employee-by-name/{name}")
        public List<EmployeeDTO> getEmployeeByName(@PathVariable(value = "name") String name){
            List<EmployeeDTO> getEmployeeByName= EmployeeService.getEmployeeByName(name);
            return  getEmployeeByName;
        }



}
