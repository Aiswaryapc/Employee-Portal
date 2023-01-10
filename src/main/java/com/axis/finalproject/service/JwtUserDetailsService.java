package com.axis.finalproject.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.axis.finalproject.entity.Employee;
import com.axis.finalproject.repository.EmployeeRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	  @Autowired
	    EmployeeRepository employeeRepository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		  Employee emp = employeeRepository.findByEmail(email);
		  if (emp == null) {
	            throw new UsernameNotFoundException("email Not found" + email);
	        }
	        return new User(emp.getEmail(), emp.getPassword(), new ArrayList<>());
	    }
	}
