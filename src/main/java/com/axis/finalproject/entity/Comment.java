package com.axis.finalproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int commentID;
	private String comment;
	 @ManyToOne
	 @JoinColumn(name = "employee_id")
	private Employee employee;
	 @JsonIgnore
	 @ManyToOne
	 @JoinColumn(name = "comment_id")
	private NewsFeed newsfeed;
	

	
	public Comment() {
		super();
	}

	public Comment(String comment, Employee employee, NewsFeed newsfeed) {
		super();
		this.comment = comment;
		this.employee = employee;
		this.newsfeed = newsfeed;
	}
	
	public NewsFeed getNewsfeed() {
		return newsfeed;
	}

	public void setNewsfeed(NewsFeed newsfeed) {
		this.newsfeed = newsfeed;
	}

	public int getCommentID() {
		return commentID;
	}
	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
