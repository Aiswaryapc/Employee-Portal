package com.axis.finalproject.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.finalproject.entity.DatabaseFile;

public interface DatabaseFileRepository extends JpaRepository<DatabaseFile, String> {

}
