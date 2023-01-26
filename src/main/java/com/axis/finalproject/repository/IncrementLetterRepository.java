package com.axis.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.finalproject.entity.IncrementLetter;
@Repository
public interface IncrementLetterRepository extends JpaRepository<IncrementLetter, String> {
	IncrementLetter findByEmpId(int id);
}
