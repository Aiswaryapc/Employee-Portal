package com.axis.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.finalproject.entity.JoiningLetter;

@Repository
public interface JoiningLetterrepository extends JpaRepository<JoiningLetter, String> {
	JoiningLetter findByEmpId(int id);
}
