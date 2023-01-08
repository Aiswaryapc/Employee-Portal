package com.axis.finalproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class Project {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;
	@OneToMany
	@JoinColumn(name="stakeholder_id")
	private Stakeholders stakeholder;
	@ManyToMany
	@JoinColumn(name="job_id")
	private JobOpportunities jobopportunities;
	private String flowChart;
	@OneToMany
	@JoinColumn(name="emp_id")
	private Employee employee;
	private String owner;
	public Project() {
		super();
	}
	public Project(Stakeholders stakeholder, JobOpportunities jobopportunities, String flowChart, Employee employee,
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
	public Stakeholders getStakeholder() {
		return stakeholder;
	}
	public void setStakeholder(Stakeholders stakeholder) {
		this.stakeholder = stakeholder;
	}
	public JobOpportunities getJobopportunities() {
		return jobopportunities;
	}
	public void setJobopportunities(JobOpportunities jobopportunities) {
		this.jobopportunities = jobopportunities;
	}
	public String getFlowChart() {
		return flowChart;
	}
	public void setFlowChart(String flowChart) {
		this.flowChart = flowChart;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
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
