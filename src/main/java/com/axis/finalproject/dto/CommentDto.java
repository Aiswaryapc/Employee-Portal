package com.axis.finalproject.dto;




public class CommentDto {
	private String comment;
	private String email;
	private String newsfeedheading;

	public CommentDto(String comment, String email, String newsfeedheading) {
		super();
		this.comment = comment;
		this.email = email;
		this.newsfeedheading = newsfeedheading;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNewsfeedheading() {
		return newsfeedheading;
	}
	public void setNewsfeedheading(String newsfeedheading) {
		this.newsfeedheading = newsfeedheading;
	}
	
}
