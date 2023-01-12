package com.axis.finalproject.product.dto;




public class CommentDto {
	private String comment;
	private String employeeName;
	private String newsfeedheading;
	public CommentDto(String comment, String employeeName, String newsfeedheading) {
		super();
		this.comment = comment;
		this.employeeName = employeeName;
		this.newsfeedheading = newsfeedheading;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getNewsfeedheading() {
		return newsfeedheading;
	}
	public void setNewsfeedheading(String newsfeedheading) {
		this.newsfeedheading = newsfeedheading;
	}
	
}
