package com.batch3.pointofsale.service.impl;

import com.batch3.pointofsale.dto.EmployeeDTO;
import com.batch3.pointofsale.entity.Employee;
import com.batch3.pointofsale.repo.EmployeeRepo;
import com.batch3.pointofsale.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceIMPL implements EmployeeService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmployeeRepo EmployeeRepo;


    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {
        if(!EmployeeRepo.existsById(employeeDTO.getEmployeeId())){
            Employee employee=new Employee(
                    employeeDTO.getEmployeeId(),
                    employeeDTO.getEmployeeName(),
                    employeeDTO.getEmployeeAddress(),
                    employeeDTO.getEmail(),
                    employeeDTO.getContactNumber(),
                    employeeDTO.getNic(),
                    employeeDTO.getPosition(),
                    employeeDTO.isActiveState()
                    );
            EmployeeRepo.save(employee);
            return "saved";
        }else {
            return "That id is already exit !!!";
        }

    }

    @Override
    public String updateEmployee(EmployeeDTO employeeDTO) {
        if (EmployeeRepo.existsById(employeeDTO.getEmployeeId())){
            Employee employee=EmployeeRepo.getById(employeeDTO.getEmployeeId());
            employee.setEmployeeName(employeeDTO.getEmployeeName());
            employee.setEmployeeAddress(employeeDTO.getEmployeeAddress());
            employee.setEmail(employeeDTO.getEmail());
            employee.setContactNumber(employeeDTO.getContactNumber());
            employee.setNic(employeeDTO.getNic());
            employee.setPosition(employeeDTO.getPosition());

            EmployeeRepo.save(employee);
            return "Update";
        }else {
            return "No employee for this id";
        }

    }



    @Override
    public EmployeeDTO getEmployeeById(int employeeId) {
        Optional<Employee> employee=EmployeeRepo.findById(employeeId);
        if (employee.isPresent()){
            EmployeeDTO employeeDTO=new EmployeeDTO(
                    employee.get().getEmployeeId(),
                    employee.get().getEmployeeName(),
                    employee.get().getEmployeeAddress(),
                    employee.get().getEmail(),
                    employee.get().getContactNumber(),
                    employee.get().getNic(),
                    employee.get().getPosition(),
                    employee.get().isActiveState()
            );
            return employeeDTO;
        }else {
            return null;
        }

    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {

        List<Employee> employees=EmployeeRepo.findAll();
        List<EmployeeDTO> employeeDTOList=new ArrayList<>();
        for (Employee e:employees){
            EmployeeDTO employeeDTO=new EmployeeDTO(
                    e.getEmployeeId(),
                    e.getEmployeeName(),
                    e.getEmployeeAddress(),
                    e.getEmail(),
                    e.getContactNumber(),
                    e.getNic(),
                    e.getPosition(),
                    e.isActiveState()

            );
            employeeDTOList.add(employeeDTO);


        }
        return employeeDTOList;
    }

    @Override
    public String deleteEmployee(int employeeId) {
        if(EmployeeRepo.existsById(employeeId))
        {
            EmployeeRepo.deleteById(employeeId);
            return "deleted";
        }else
        {
            return "No Employee for this number";
        }

    }

    @Override
    public List<EmployeeDTO> getEmployeeByName(String name) {
        List<Employee> employeeList=EmployeeRepo.findAllByEmployeeNameEquals(name);
        if(employeeList.size()>0){
            List<EmployeeDTO> employeeDTOList=modelMapper.map(employeeList,new TypeToken<List<EmployeeDTO>>(){}
                    .getType());
            return employeeDTOList;
        }
        else {
            return null;
        }

    }


}
