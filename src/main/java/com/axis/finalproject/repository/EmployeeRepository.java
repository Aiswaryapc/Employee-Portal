package com.axis.finalproject.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.axis.finalproject.entity.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByemail(String email);
    Employee findByName(String name);
    List<Employee> findAllByOrderByName();
    
    

    Boolean existsByEmail(String email);
}