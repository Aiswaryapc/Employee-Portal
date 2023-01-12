package com.axis.finalproject.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class NewsFeed {
	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer newsFeedId;
	  	private String heading;
	  	private String description;
	  	private String image;
		@OneToMany(mappedBy = "newsfeed", fetch = FetchType.LAZY,
				cascade = CascadeType.ALL )
		Set<Comment> comment;
		 @ManyToOne
		 @JoinColumn(name = "employee_id")
		private Employee employee;
		public NewsFeed() {
			super();
		}
	
	


		public NewsFeed(String heading, String description, String image, Employee employee) {
			super();
			this.heading = heading;
			this.description = description;
			this.image = image;
			this.employee = employee;
		}




		public Employee getEmployee() {
			return employee;
		}



		public void setEmployee(Employee employee) {
			this.employee = employee;
		}



		public Set<Comment> getComment() {
			return comment;
		}

		public void setComment(Set<Comment> comment) {
			this.comment = comment;
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
