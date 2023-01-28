package com.axis.finalproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.finalproject.dto.CommentDto;
import com.axis.finalproject.entity.Comment;

import com.axis.finalproject.exceptions.CommentNotFoundException;
import com.axis.finalproject.repository.CommentRepository;
import com.axis.finalproject.repository.EmployeeRepository;
import com.axis.finalproject.repository.NewsFeedRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private NewsFeedRepository newsFeedRepository;
	
	public Comment getCommentById(Integer commentId) {
		Optional<Comment> comment=commentRepository.findById(commentId);
		if(!comment.isPresent()) 
			throw new CommentNotFoundException("Comment not found by id "+commentId);
		return comment.get();

	}

	
	public List<Comment> getAllComments() {
		
		return (List<Comment>) commentRepository.findAll();
	}


	public void addComment(CommentDto commentDto) {
		Comment comment = new Comment(commentDto.getComment(),
				employeeRepository.findByemail(commentDto.getEmail()),
				newsFeedRepository.findByHeading(commentDto.getNewsfeedheading())
				);
		commentRepository.save(comment);
	}

	
	public void deleteCommentById(Integer commentId) {
		
		commentRepository.deleteById(commentId);

	}
}

