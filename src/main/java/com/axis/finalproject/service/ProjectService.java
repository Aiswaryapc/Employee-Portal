package com.axis.finalproject.service;
import java.util.List;

import com.axis.finalproject.entity.Project;
import com.axis.finalproject.product.dto.ProjectDto;



public interface ProjectService {
	Project getProjectById(Integer projectId);

	List<Project> getAllProjects();

	void addProject(ProjectDto project);

	void deleteProjectById(Integer projectId);

	void updateProject (Integer projectId,Project project);
}