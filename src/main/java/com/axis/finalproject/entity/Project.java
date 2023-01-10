package com.axis.finalproject.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;



@Entity
public class Project {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY,
			cascade = CascadeType.ALL )
	Set<Stakeholders> stakeholder;
//	@ManyToMany
//	@JoinColumn(name="job_id")
	private String jobopportunities;
	private String flowChart;
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY,
			cascade = CascadeType.ALL )
	Set<Employee> employee;
	
	private String owner;
	public Project() {
		super();
	}
	public Project(Set<Stakeholders> stakeholder, String jobopportunities, String flowChart, Set<Employee> employee,
			String owner) {
		super();
		this.stakeholder = stakeholder;
		this.jobopportunities = jobopportunities;
		this.flowChart = flowChart;
		this.employee = employee;
		this.owner = owner;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public Set<Stakeholders> getStakeholder() {
		return stakeholder;
	}
	public void setStakeholder(Set<Stakeholders> stakeholder) {
		this.stakeholder = stakeholder;
	}
	public String getJobopportunities() {
		return jobopportunities;
	}
	public void setJobopportunities(String jobopportunities) {
		this.jobopportunities = jobopportunities;
	}
	public String getFlowChart() {
		return flowChart;
	}
	public void setFlowChart(String flowChart) {
		this.flowChart = flowChart;
	}
	public Set<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", stakeholder=" + stakeholder + ", jobopportunities="
				+ jobopportunities + ", flowChart=" + flowChart + ", employee=" + employee + ", owner=" + owner + "]";
	}
	
	
	
}
