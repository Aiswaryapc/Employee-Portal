package com.axis.finalproject.product.dto;

public class NewsFeedDto {
	private String heading;
  	private String description;
  	private String image;
  	private String email;


	


	public NewsFeedDto(String heading, String description, String image, String email) {
		super();
		this.heading = heading;
		this.description = description;
		this.image = image;
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
