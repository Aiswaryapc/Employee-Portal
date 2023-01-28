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

import com.axis.finalproject.dto.employee.SignupDto;
import com.axis.finalproject.entity.Employee;
import com.axis.finalproject.service.EmployeeeService;



@RestController
@RequestMapping("/api/test/")
@CrossOrigin("http://localhost:3000")
public class EmployeeController {
	@Autowired
	private EmployeeeService empService;
 
	
	@GetMapping("emp/{empId}")
	public Employee getEmployeeById(@PathVariable Integer empId) {
		return empService.getEmployeeId(empId);
	
	}
	
	//@PreAuthorize("hasRole('ROLE_USER')  or hasRole('ROLE_ADMIN')")
	@GetMapping("/employees")
	public List<Employee> getEmployee()	{
		return empService.getAllEmployees();
		}
	@PutMapping("emp/update/{empID}")
	public ResponseEntity<String> updateEmpInfo(@PathVariable int empID,@RequestBody SignupDto updatedEmployee){
		empService.updateEmployee(empID, updatedEmployee);
		return new ResponseEntity<String>("Employee with empID id:"+ empID+" updated successfully",HttpStatus.OK);
	}
	
	@DeleteMapping("emp/delete/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer empId){
		empService.deleteEmployeeById(empId);
		return new ResponseEntity<String>("Employee Deleted!!!",HttpStatus.OK);
	}

	

}
