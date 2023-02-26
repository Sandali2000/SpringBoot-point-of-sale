package com.batch3.pointofsale.repo;

import com.batch3.pointofsale.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    List<Employee> findAllByEmployeeNameEquals(String name);
}
