package com.axis.finalproject.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.axis.finalproject.entity.Project;
import com.axis.finalproject.service.ProjectService;

@RestController
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	
//	@Autowired
//	private rest
	
	@GetMapping("project/{projectId}")
	public Project getProjectById(@PathVariable Integer projectId) {
		return projectService.getProjectById(projectId);
	}
	
	@GetMapping("projects")
	public List<Project> getProjects(){
		return projectService.getAllProjects();
	}
	
	@PostMapping("/project")
	public ResponseEntity<String> addProject(@RequestBody Project project){
		projectService.addProject(project);
		return new ResponseEntity<String>("Project added Successfuly",HttpStatus.OK);
	}
	
	@DeleteMapping("project/delete/{projectId}")
	public ResponseEntity<String> deleteProject(@PathVariable Integer projectId){
		projectService.deleteProjectById(projectId);
		return new ResponseEntity<String>("Project deleted Successfuly",HttpStatus.OK);
		
	}
	@PutMapping("/project/update/{projectId}")
	public ResponseEntity<String> updateBankInfo(@PathVariable Integer projectId,@RequestBody Project updatedProject){
		projectService.updateProject(projectId, updatedProject);
		return new ResponseEntity<String>("Bank with bank id:"+ projectId+" updated successfully",HttpStatus.OK);
	}
	
}
