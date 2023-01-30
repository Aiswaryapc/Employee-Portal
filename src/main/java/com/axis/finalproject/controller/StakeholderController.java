package com.axis.finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.finalproject.dto.StakeholderDto;
import com.axis.finalproject.dto.employee.SignupDto;
import com.axis.finalproject.entity.Stakeholders;
import com.axis.finalproject.service.StakeholderService;

@RestController
@RequestMapping("/api/test/")
@CrossOrigin("http://localhost:3000")
public class StakeholderController {
	@Autowired
	private StakeholderService stakeholderService;
	

	
	@GetMapping("stakeholder/{stakeholderId}")
	public Stakeholders getStakeholderById(@PathVariable Integer stakeholderId) {
		return stakeholderService.getStakeholderById(stakeholderId);
	}
	
	@GetMapping("stakeholders")
	public List<Stakeholders> getStakeholders(){
		return stakeholderService.getAllStakeholders();
	}
	
	@PostMapping("add/stakeholder")
	public ResponseEntity<String> addStakeholder(@RequestBody StakeholderDto stakeholderDto){
		stakeholderService.addStakeholders(stakeholderDto);
		return new ResponseEntity<String>("Stakeholder added Successfuly",HttpStatus.OK);
	}
	@PostMapping("stakeholder/update/{stakeholderId}")
	public ResponseEntity<String> updateEmpInfo(@PathVariable int stakeholderId,@RequestBody StakeholderDto stakeholderDto){
		stakeholderService.updateStakeholder(stakeholderId, stakeholderDto);
		return new ResponseEntity<String>("Stakeholder with stakeholderId id:"+ stakeholderId+" updated successfully",HttpStatus.OK);
	}
	@DeleteMapping("stakeholder/delete/{stakeholderId}")
	public ResponseEntity<String> deleteStakeholder(@PathVariable Integer stakeholderId){
		stakeholderService.deleteStakeholderById(stakeholderId);
		return new ResponseEntity<String>("Stakeholder deleted Successfuly",HttpStatus.OK);
		
	}

}
