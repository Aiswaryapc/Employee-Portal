package com.axis.finalproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.finalproject.entity.Employee;
import com.axis.finalproject.exceptions.EmployeeNotFoundException;
import com.axis.finalproject.repository.EmployeeRepository;

@Service
public class EmployeeeService {

	
	@Autowired
	private EmployeeRepository employeeRepository;
	public Employee getEmployeeId(Integer empId) {
		Optional<Employee> emp=employeeRepository.findById(empId);
		if(!emp.isPresent()) 
			throw new EmployeeNotFoundException("NewsFeed not found by id "+empId);
		return emp.get();

	}

	
	public List<Employee> getAllEmployees() {
		
		return (List<Employee>) employeeRepository.findAll();
	}



	
	public void deleteEmployeeById(Integer empId) {
		
		employeeRepository.deleteById(empId);

	}
}
