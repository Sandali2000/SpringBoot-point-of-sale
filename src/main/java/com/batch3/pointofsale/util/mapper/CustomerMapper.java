package com.batch3.pointofsale.util.mapper;

import com.batch3.pointofsale.dto.response.ResponseAllCustomerDTO;
import com.batch3.pointofsale.entity.Customer;
import com.batch3.pointofsale.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")

public interface CustomerMapper {
    List<ResponseAllCustomerDTO> pageToDto(Page<Customer> customers);
}
