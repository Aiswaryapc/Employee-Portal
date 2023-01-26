package com.axis.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.finalproject.entity.AppointmentLetter;
@Repository
public interface AppointmentLetterRepository extends JpaRepository<AppointmentLetter, String> {
	
	AppointmentLetter findByEmpId(int id);
}
