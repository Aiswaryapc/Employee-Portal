package com.axis.finalproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
	private String category;
	private String name;
	private String imageUrl;
	private String detailedImageUrl;
	private String description;
	public Product() {
		super();
	}
	public Product(String category, String name, String imageUrl, String detailedImageUrl, String description) {
		super();
		this.category = category;
		this.name = name;
		this.imageUrl = imageUrl;
		this.detailedImageUrl = detailedImageUrl;
		this.description = description;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
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
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", category=" + category + ", name=" + name + ", imageUrl="
				+ imageUrl + ", detailedImageUrl=" + detailedImageUrl + ", description=" + description + "]";
	}
	
	
	
	
	
	
}
