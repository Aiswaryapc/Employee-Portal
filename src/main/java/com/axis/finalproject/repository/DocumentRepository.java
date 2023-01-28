package com.axis.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.finalproject.entity.Document;



@Repository
public interface DocumentRepository extends JpaRepository<Document, String> {

}