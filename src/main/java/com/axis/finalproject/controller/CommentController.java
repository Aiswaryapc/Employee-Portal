package com.axis.finalproject.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.finalproject.dto.CommentDto;
import com.axis.finalproject.entity.Comment;
import com.axis.finalproject.service.CommentService;

@RestController
@RequestMapping("/api/test/")
@CrossOrigin("http://localhost:3000")
public class CommentController {
	@Autowired
	private CommentService commentService;
 
	
	@GetMapping("comment/{commentId}")
	public Comment getCommentId(@PathVariable Integer commentId) {
		return  commentService.getCommentById(commentId);
	
	}
	
	@GetMapping("comment")
	public List<Comment> getComment()	{
		return commentService.getAllComments();
		}
	
	@PostMapping("comment/add")
	public ResponseEntity<String> addComment(@RequestBody CommentDto comment){
		commentService.addComment(comment);
		return new ResponseEntity<String>("Comment added!!!",HttpStatus.CREATED);
	}
	
	@DeleteMapping("comment/delete/{commentId}")
	public ResponseEntity<String> deleteComment(@PathVariable Integer commentId){
		commentService.deleteCommentById(commentId);
		return new ResponseEntity<String>("Comment Deleted!!!",HttpStatus.OK);
	}

	}
