package com.axis.finalproject.dto;

public class ProductDto {
	private String category;
	private String name;
	private String imageUrl;
	private String detailedImageUrl;
	private String description;
	public ProductDto() {
		super();
	}
	
	public ProductDto(String category, String name, String imageUrl, String detailedImageUrl, String description) {
		super();
		this.category = category;
		this.name = name;
		this.imageUrl = imageUrl;
		this.detailedImageUrl = detailedImageUrl;
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getDetailedImageUrl() {
		return detailedImageUrl;
	}
	public void setDetailedImageUrl(String detailedImageUrl) {
		this.detailedImageUrl = detailedImageUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}