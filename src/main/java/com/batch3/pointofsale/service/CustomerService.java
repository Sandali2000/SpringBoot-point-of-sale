package com.batch3.pointofsale.service;

import com.batch3.pointofsale.dto.CustomerDTO;
import com.batch3.pointofsale.dto.paginate.PaginateResponseCustomerDTO;
import com.batch3.pointofsale.dto.paginate.PaginateResponseItemDTO;
import com.batch3.pointofsale.dto.request.RequestUpdateCustomerDTO;
import com.batch3.pointofsale.dto.response.ResponseActiveCustomerDTO;

import java.util.List;

public interface CustomerService  {
    String addCustomer(CustomerDTO CustomerDTO);


    String updateCustomers(CustomerDTO customerDTO);

    CustomerDTO getCustomer(int customerId);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomer(int customerId);


    List<CustomerDTO> getAllCustomerByName(String name);

    List<CustomerDTO> getActiveCustomerByName(String name);

    List<ResponseActiveCustomerDTO> getAllActiveCustomer();


    String updateCustomerByQuery(RequestUpdateCustomerDTO customerDTO, int id);

     Long countAllCustomer();

    PaginateResponseCustomerDTO getAllCustomerByPaginate(int page, int size);
}
