package com.axis.finalproject.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Project {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY,
			cascade = CascadeType.ALL )
	List<Stakeholders> stakeholder;
	private String projName;
//	@ManyToMany
//	@JoinColumn(name="job_id")
	private String jobopportunities;
	private String flowChart;
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY,
			cascade = CascadeType.ALL )
	List<Employee> employee;
	
	private String owner;
	public Project() {
		super();
	}



	public Project(String projName, String jobopportunities, String flowChart, String owner) {
		super();
		this.projName = projName;
		this.jobopportunities = jobopportunities;
		this.flowChart = flowChart;
		this.owner = owner;
	}



	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public List<Stakeholders> getStakeholder() {
		return stakeholder;
	}
	public void setStakeholder(List<Stakeholders> stakeholder) {
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
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
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
