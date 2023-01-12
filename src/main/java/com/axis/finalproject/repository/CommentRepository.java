package com.axis.finalproject.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.axis.finalproject.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {


	
}