package com.axis.finalproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
@Entity
public class JobOpportunities {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobId;
	private String domain;
	private String jobLocation;
	private String ctc;
	private int  experiance;
	private String description;
	private int vacancies;
	@ManyToMany
	@JoinColumn(name="project_id")
	private Project project;
	public JobOpportunities() {
		super();
	}
	
	public JobOpportunities(String domain, String jobLocation, String ctc, int experiance, String description,
			int vacancies, Project project) {
		super();
		this.domain = domain;
		this.jobLocation = jobLocation;
		this.ctc = ctc;
		this.experiance = experiance;
		this.description = description;
		this.vacancies = vacancies;
		this.project = project;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getJobLocation() {
		return jobLocation;
	}
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}
	public String getCtc() {
		return ctc;
	}
	public void setCtc(String ctc) {
		this.ctc = ctc;
	}
	public int getExperiance() {
		return experiance;
	}
	public void setExperiance(int experiance) {
		this.experiance = experiance;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getVacancies() {
		return vacancies;
	}
	public void setVacancies(int vacancies) {
		this.vacancies = vacancies;
	}

	@Override
	public String toString() {
		return "JobOpportunities [jobId=" + jobId + ", domain=" + domain + ", jobLocation=" + jobLocation + ", ctc="
				+ ctc + ", experiance=" + experiance + ", description=" + description + ", vacancies=" + vacancies
				+ ", project=" + project + "]";
	}

	
	
	
	
}

