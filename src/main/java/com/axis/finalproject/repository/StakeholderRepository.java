package com.axis.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.axis.finalproject.entity.Stakeholders;

@Repository
public interface StakeholderRepository extends JpaRepository<Stakeholders, Integer> {
	Stakeholders findByEmail(String email);
	Stakeholders findBystakeholderId(Integer stakeholderId);
}
