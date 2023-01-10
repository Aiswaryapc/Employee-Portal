package com.axis.finalproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Admin {
 	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aId;
 	private String adminId;
 	private String password;
 	
 	
 	
	public Admin(String userId, String password) {
		super();
		this.adminId = userId;
		this.password = password;
	}
	public Admin() {
		super();
	}
	public Integer getaId() {
		return aId;
	}
	public void setaId(Integer aId) {
		this.aId = aId;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
 	
}
