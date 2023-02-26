package com.batch3.pointofsale.service.impl;

import com.batch3.pointofsale.dto.CustomerDTO;
import com.batch3.pointofsale.dto.paginate.PaginateResponseCustomerDTO;
import com.batch3.pointofsale.dto.paginate.PaginateResponseItemDTO;
import com.batch3.pointofsale.dto.request.RequestUpdateCustomerDTO;
import com.batch3.pointofsale.dto.response.ResponseActiveCustomerDTO;
import com.batch3.pointofsale.dto.response.ResponseAllCustomerDTO;
import com.batch3.pointofsale.entity.Customer;
import com.batch3.pointofsale.repo.CustomerRepo;
import com.batch3.pointofsale.service.CustomerService;
import com.batch3.pointofsale.util.mapper.CustomerMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepo CustomerRepo;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public String addCustomer(CustomerDTO CustomerDTO) {
        Customer Customer=new Customer(
                CustomerDTO.getCustomerId(),
                CustomerDTO.getCustomerName(),
                CustomerDTO.getCustomerAddress(),
                CustomerDTO.getCustomerSalary(),
                CustomerDTO.getContactNumber(),
                CustomerDTO.getNic(),
                CustomerDTO.isActiveState()
        );

        if(!CustomerRepo.existsById(CustomerDTO.getCustomerId())){
            CustomerRepo.save(Customer);
            return "saved "+Customer.getCustomerName();

        }else
        {
            System.out.println("Customer id already exits ");
            return "Customer id already exits !";
        }

    }

    @Override
    public String updateCustomers(CustomerDTO customerDTO) {
        if(CustomerRepo.existsById(customerDTO.getCustomerId())){
            Customer customer= CustomerRepo.getById(customerDTO.getCustomerId());
            customer.setCustomerName(customerDTO.getCustomerName());
            customer.setCustomerAddress(customerDTO.getCustomerAddress());
            customer.setCustomerSalary(customerDTO.getCustomerSalary());
            customer.setContactNumber(customerDTO.getContactNumber());
            customer.setNic(customerDTO.getNic());
            customer.setActiveState(customerDTO.isActiveState());

            CustomerRepo.save(customer);
           return "updated";

        }else {
            return "Not found this customer id";
        }

    }

    @Override
    public CustomerDTO getCustomer(int customerId) {
        Optional<Customer> customer=CustomerRepo.findById(customerId);
        CustomerDTO customerDTO=modelMapper.map(customer.get(),CustomerDTO.class);
        return customerDTO;

 //       if (customer.isPresent()){
 //               CustomerDTO customerDTO=new CustomerDTO(
 //                       customer.get().getCustomerId(),
 //                       customer.get().getCustomerName(),
 //                       customer.get().getCustomerAddress(),
 //                       customer.get().getCustomerSalary(),
 //                       customer.get().getContactNumber(),
 //                       customer.get().getNic(),
 //                       customer.get().isActiveState()
//
//                );
//                return customerDTO;
//        }else {
//            return null;
//    }

    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> allCustomer = CustomerRepo.findAll();
        List<CustomerDTO> customerDTOList=new ArrayList<>();

        for (Customer c:allCustomer){
            CustomerDTO customerDTO=new CustomerDTO(
                    c.getCustomerId(),
                    c.getCustomerName(),
                    c.getCustomerAddress(),
                    c.getCustomerSalary(),
                    c.getContactNumber(),
                    c.getNic(),
                    c.isActiveState()
            );
                customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

    @Override
    public String deleteCustomer(int customerId) {
        if (CustomerRepo.existsById(customerId)){
            CustomerRepo.deleteById(customerId);
            return "Deleted";
        }else {
            return "No customer for this id";
        }


    }

    @Override
    public List<CustomerDTO> getAllCustomerByName(String name) {
        List<Customer> customerList = CustomerRepo.findAllByCustomerNameEquals(name);
        if (customerList.size()>0){
            List<CustomerDTO> customerDTOList = modelMapper.map(customerList,new TypeToken<List<CustomerDTO>>(){}
                    .getType());
            return customerDTOList;
        }else {
            return null;
        }



    }

    @Override
    public List<CustomerDTO> getActiveCustomerByName(String name) {
        List<Customer> customers=CustomerRepo.findAllByCustomerNameEqualsAndActiveStateEquals(name,true);
        List<CustomerDTO> customerDTOList=modelMapper.map(customers,new TypeToken<List<CustomerDTO>>(){}.getType());
        return customerDTOList;
    }

    @Override
    public List<ResponseActiveCustomerDTO> getAllActiveCustomer() {
        List<Customer> customers=CustomerRepo.findAllByActiveStateEquals(true);
        if(customers.size()>0)
        {
            List<ResponseActiveCustomerDTO> customerDTOList=modelMapper.map(customers,new TypeToken<List
                    <ResponseActiveCustomerDTO>>(){}.getType());
            return customerDTOList;
        }else {
            return null;
        }
    }

    @Override
    public String updateCustomerByQuery(RequestUpdateCustomerDTO customerDTO, int id) {
        if(CustomerRepo.existsById(id)){
            CustomerRepo.updateCustomerByQuery(customerDTO.getCustomerName(),customerDTO.getCustomerAddress(),
                    customerDTO.getCustomerSalary(),id);
           return "update successfully";
        }else {
            return null;
        }


    }

    @Override
    public Long countAllCustomer() {
     return    CustomerRepo.count();

    }

    @Override
    public PaginateResponseCustomerDTO getAllCustomerByPaginate(int page, int size) {
        Page<Customer> customers=CustomerRepo.findAll(PageRequest.of(page ,size));
        PaginateResponseCustomerDTO paginateResponseCustomerDTO=new  PaginateResponseCustomerDTO(
                customerMapper.pageToDto(customers),
                CustomerRepo.count()

        );
                return paginateResponseCustomerDTO;
    }


}
