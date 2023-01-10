package com.axis.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.axis.finalproject.entity.Employee;
import com.axis.finalproject.repository.EmployeeRepository;




@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	EmployeeRepository empRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee user = empRepository.findByEmail(username);
				//.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsImpl.build(user);
	}


}