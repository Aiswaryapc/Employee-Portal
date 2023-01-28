package com.axis.finalproject.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.finalproject.dto.employee.SignupDto;
import com.axis.finalproject.entity.Employee;
import com.axis.finalproject.exceptions.EmployeeNotFoundException;
import com.axis.finalproject.repository.EmployeeRepository;
import com.axis.finalproject.repository.ProjectRepository;

@Service
public class EmployeeeService {

	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ProjectRepository projectRepository;
	public Employee getEmployeeId(Integer empId) {
		Optional<Employee> emp=employeeRepository.findById(empId);
		if(!emp.isPresent()) 
			throw new EmployeeNotFoundException("NewsFeed not found by id "+empId);
		return emp.get();

	}

	
	public List<Employee> getAllEmployees() {
		
		return (List<Employee>) employeeRepository.findAllByOrderByName();
	}

	@Transactional
	public Employee updateEmployee(int empID,SignupDto updatedEmployee) {
		 Employee emp
         = employeeRepository.findById(empID)
               .get();

     if (Objects.nonNull(updatedEmployee.getAge())
        ) {
         emp.setAge(
        		 updatedEmployee.getAge());
     }
     if (Objects.nonNull(updatedEmployee.getDesignation())
             && !"".equalsIgnoreCase(
            		 updatedEmployee.getDesignation())) {
             emp.setDesignation(
            		 updatedEmployee.getDesignation());
         }
     if (Objects.nonNull(updatedEmployee.getAddress())
             && !"".equalsIgnoreCase(
            		 updatedEmployee.getAddress())) {
             emp.setAddress(
            		 updatedEmployee.getAddress());
         }
     if (Objects.nonNull(updatedEmployee.getCity())
             && !"".equalsIgnoreCase(
            		 updatedEmployee.getCity())) {
             emp.setCity(
            		 updatedEmployee.getCity());
         }
     if (Objects.nonNull(updatedEmployee.getMobileNumber())
             && !"".equalsIgnoreCase(
            		 updatedEmployee.getMobileNumber())) {
             emp.setMobileNumber(
            		 updatedEmployee.getMobileNumber());
         }
     if (Objects.nonNull(updatedEmployee.getState())
             && !"".equalsIgnoreCase(
            		 updatedEmployee.getState())) {
             emp.setState(
            		 updatedEmployee.getState());
         }
     if (Objects.nonNull(updatedEmployee.getSupervisor())
             && !"".equalsIgnoreCase(
            		 updatedEmployee.getSupervisor())) {
             emp.setSupervisor(
            		 updatedEmployee.getSupervisor());
         }
     if (Objects.nonNull(updatedEmployee.getProject())
            ) {
            		 
             emp.setProject(projectRepository.findByProjName(updatedEmployee.getProject()));
            		
         }


     return employeeRepository.save(emp);
	}

	
	public void deleteEmployeeById(Integer empId) {
		
		employeeRepository.deleteById(empId);

	}
}
