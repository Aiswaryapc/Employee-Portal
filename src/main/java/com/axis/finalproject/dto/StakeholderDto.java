package com.axis.finalproject.dto;




public class StakeholderDto {
	private String name;
	private String organaization;
	private String position;
	private String email;
	private String state;
	private String project;
	public StakeholderDto(String name, String organaization, String position, String email, String state,
			String project) {
		super();
		this.name = name;
		this.organaization = organaization;
		this.position = position;
		this.email = email;
		this.state = state;
		this.project = project;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrganaization() {
		return organaization;
	}
	public void setOrganaization(String organaization) {
		this.organaization = organaization;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	
}
