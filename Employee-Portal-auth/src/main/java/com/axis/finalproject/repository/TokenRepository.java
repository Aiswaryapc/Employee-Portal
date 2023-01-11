//package com.axis.finalproject.repository;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import com.axis.finalproject.entity.Admin;
//import com.axis.finalproject.entity.AuthenticationToken;
//import com.axis.finalproject.entity.Employee;
//
//
//
//@Repository
//public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer> {
//
//    AuthenticationToken findByEmployee(Employee employee);
//    AuthenticationToken findByAdmin(Admin admin);
//    AuthenticationToken findByToken(String token);
//}