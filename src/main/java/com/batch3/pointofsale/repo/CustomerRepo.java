package com.batch3.pointofsale.repo;

import com.batch3.pointofsale.dto.request.RequestUpdateCustomerDTO;
import com.batch3.pointofsale.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@EnableJpaRepositories
@Repository
@Transactional
public interface CustomerRepo extends JpaRepository<Customer,Integer> {

    List<Customer> findAllByCustomerNameEquals(String name);

    List<Customer> findAllByCustomerNameEqualsAndActiveStateEquals(String name,boolean b);

    List<Customer> findAllByActiveStateEquals(boolean b);

    @Modifying
    @Query(value = "update customer set customer_name=?1, customer_address=?2, customer_salary=?3 where customer_id=?4",nativeQuery = true)
    void updateCustomerByQuery(String customerName, String customerAddress, double customerSalary, int id);
}
