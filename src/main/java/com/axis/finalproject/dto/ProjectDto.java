package com.axis.finalproject.dto;

import java.util.List;
import java.util.Set;



public class ProjectDto {

	private String projName;
	private String jobopportunities;
	private String flowChart;

	private String owner;
	public ProjectDto() {
		super();
	}
	
	public ProjectDto(String projName, String jobopportunities, String flowChart, String owner) {
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
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	
	
}
