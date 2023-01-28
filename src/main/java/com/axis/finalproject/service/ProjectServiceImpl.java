package com.axis.finalproject.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import com.axis.finalproject.dto.ProjectDto;
import com.axis.finalproject.entity.Employee;
import com.axis.finalproject.entity.Project;
import com.axis.finalproject.entity.Stakeholders;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.axis.finalproject.exceptions.ProjectNotFoundException;
import com.axis.finalproject.repository.EmployeeRepository;

import com.axis.finalproject.repository.ProjectRepository;
import com.axis.finalproject.repository.StakeholderRepository;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private StakeholderRepository stakeholderRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
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
	public void addProject(ProjectDto projectDto) {
		// TODO Auto-generated method stub
			
//		Iterator<String> shItr = projectDto.getStakeholder().iterator();
//		List<Stakeholders> stake = new ArrayList<Stakeholders>();
//		while(shItr.hasNext()) {
//			stake.add(stakeholderRepository.findByName(shItr.next()));
//		}
//		
//		Iterator<String> empItr = projectDto.getEmployee().iterator();
//		List<Employee> emp = new ArrayList<Employee>();
//		while(empItr.hasNext()) {
//			emp.add(employeeRepository.findByName(empItr.next()));
//			System.out.println(empItr.next());
//		}
//		System.out.println(stake);
//		
		
		
		Project project= new Project(
			
				projectDto.getProjName(),
				projectDto.getJobopportunities(),
				projectDto.getFlowChart(),
				
				projectDto.getOwner()
				);
		
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
