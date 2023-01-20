package com.axis.finalproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Stakeholders {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stakeholderId;
	private String name;
	private String organaization;
	private String position;
	private String email;
	private String state;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;
	public Stakeholders() {
		super();
	}
	public Stakeholders(String name, String organaization, String position, String email, String state,
			Project project) {
		super();
		this.name = name;
		this.organaization = organaization;
		this.position = position;
		this.email = email;
		this.state = state;
		this.project = project;
	}
	public Integer getStakeholderId() {
		return stakeholderId;
	}
	public void setStakeholderId(Integer stakeholderId) {
		this.stakeholderId = stakeholderId;
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
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	@Override
	public String toString() {
		return "Stakeholders [stakeholderId=" + stakeholderId + ", name=" + name + ", organaization=" + organaization
				+ ", position=" + position + ", email=" + email + ", state=" + state + ", project=" + project + "]";
	}
	
	
	
	
}
