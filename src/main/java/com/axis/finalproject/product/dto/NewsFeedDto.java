package com.axis.finalproject.product.dto;

public class NewsFeedDto {
	private String heading;
  	private String description;
  	private String image;
  	private String employeeName;

	public NewsFeedDto(String heading, String description, String image, String employeeName) {
		super();
		this.heading = heading;
		this.description = description;
		this.image = image;
		this.employeeName = employeeName;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
 
}
