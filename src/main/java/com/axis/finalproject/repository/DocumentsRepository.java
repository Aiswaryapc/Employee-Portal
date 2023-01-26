package com.axis.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.finalproject.entity.SalarySlip;
@Repository
public interface DocumentsRepository extends JpaRepository<SalarySlip, String> {

}
