package com.axis.finalproject.service;

import java.util.List;

import com.axis.finalproject.entity.Project;
import java.util.List;
import java.util.Optional;

import com.axis.finalproject.entity.Project;
import com.axis.finalproject.exceptions.ProjectNotFoundException;
import com.axis.finalproject.repository.ProjectRepository;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project getProjectById(Integer projectId) {
		Optional<Project> projOpt=projectRepository.findById(projectId);
		if(!projOpt.isPresent()) 
			throw new ProjectNotFoundException("Bank not found by id "+projectId);
		return projOpt.get();

	}

	@Override
	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
		return (List<Project>) projectRepository.findAll();
	}

	@Override
	public void addProject(Project project) {
		// TODO Auto-generated method stub
		projectRepository.save(project);
	}

	@Override
	public void deleteProjectById(Integer projectId) {
		// TODO Auto-generated method stub
		projectRepository.deleteById(projectId);

	}
	@Transactional
	@Override
	public void updateProject(Integer projectId, Project updatedProject) {
		// TODO Auto-generated method stub
		projectRepository.updateProjectInfo(updatedProject.getStakeholder(), updatedProject.getJobopportunities(),updatedProject.getFlowChart(),
				updatedProject.getEmployee(), updatedProject.getProjectId());

	}

}
