package com.batch3.pointofsale.controller;

import com.batch3.pointofsale.dto.CustomerDTO;

import com.batch3.pointofsale.dto.paginate.PaginateResponseCustomerDTO;
import com.batch3.pointofsale.dto.request.RequestUpdateCustomerDTO;
import com.batch3.pointofsale.dto.response.ResponseActiveCustomerDTO;
import com.batch3.pointofsale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService CustomerService;

    @PostMapping(path = "/save")
    public String SaveCustomer(@RequestBody CustomerDTO CustomerDTO){
        String id=CustomerService.addCustomer(CustomerDTO);
        return id;
    }

    @PutMapping(path = "/update")
    public String updateCustomer(@RequestBody CustomerDTO customerDTO){
        String update= CustomerService.updateCustomers(customerDTO);
        return update;
    }

    @GetMapping(path ="/get-by-id",
                params = "id")
    public CustomerDTO getCustomerById(@RequestParam (value = "id") int customerId){
        CustomerDTO customerDTO= CustomerService.getCustomer(customerId);
        return  customerDTO;
    }

    @GetMapping(path ="/get-all-cutomers" )
    public List<CustomerDTO> getAllCustomers(){
        List<CustomerDTO> allCustomers=CustomerService.getAllCustomers();
        return allCustomers;
    }

    @DeleteMapping(path = "Delete-customer/{id}")
    public String deleteCustomer(@PathVariable (value = "id" )int customerId){
        String delete= CustomerService.deleteCustomer(customerId);
        return delete;
    }

    @GetMapping(path ="/get-customers-by-name", params = "name")
    public List<CustomerDTO> getCustomerByName(@RequestParam (value = "name")String name){
        List<CustomerDTO> customerDTOList=CustomerService.getAllCustomerByName(name);
        return customerDTOList;
    }

    @GetMapping(path = "/get-active-customer-by-name", params = "name")
    public List<CustomerDTO> getActiveCustomerByName(@RequestParam (value = "name" )String name){
        List<CustomerDTO> customerDTOList=CustomerService.getActiveCustomerByName(name);
        return customerDTOList;
    }
    @GetMapping(path = "/get-active-customer" )
    public List<ResponseActiveCustomerDTO> getAllActiveCustomer(){
        List<ResponseActiveCustomerDTO> customerDTOList=CustomerService.getAllActiveCustomer();
        return customerDTOList;
    }

    @PutMapping(path = "/update-customer-by-query/{id}")
    public String updateCustomerByQuery(@RequestBody RequestUpdateCustomerDTO customerDTO, @PathVariable(value = "id")int id){
        String update=CustomerService.updateCustomerByQuery(customerDTO,id);
        return update;
    }
    @GetMapping("/count")
    public Long countAllCustomer(){
       Long id= CustomerService.countAllCustomer();
        return id;

    }
    @GetMapping(value = "/get-all-customer-by-paginate",
            params = {"size", "page"})
    public PaginateResponseCustomerDTO getAllCustomerByPaginate(@RequestParam (value = "page")   int page,
                                                                @RequestParam(value = "size")@Max(50) int size){
        PaginateResponseCustomerDTO paginateResponseCustomerDTO= CustomerService.getAllCustomerByPaginate(page, size);
        return paginateResponseCustomerDTO;
    }
}
