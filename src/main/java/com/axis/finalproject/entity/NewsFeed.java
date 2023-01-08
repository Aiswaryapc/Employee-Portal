package com.axis.finalproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NewsFeed {
	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer newsFeedId;
	  	private String heading;
	  	private String description;
	  	private String image;
	 
		public NewsFeed() {
			super();
		}
		public NewsFeed(String heading, String description, String image) {
			super();
			this.heading = heading;
			this.description = description;
			this.image = image;
			
		}
		public Integer getNewsFeedId() {
			return newsFeedId;
		}
		public void setNewsFeedId(Integer newsFeedId) {
			this.newsFeedId = newsFeedId;
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
