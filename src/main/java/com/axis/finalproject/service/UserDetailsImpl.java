package com.axis.finalproject.service;


import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.axis.finalproject.entity.Employee;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	 private int empID;
	 private String name;
	 private String gender;
	 private int age;
	 private String address;
	 private String city;
	 private String state;
	 private String mobileNumber;
	 private String email;
	
	 private String supervisor;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	

	public UserDetailsImpl(int empID, String name, String gender, int age, String address, String city, String state,
			String mobileNumber, String email, String supervisor, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.empID = empID;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.city = city;
		this.state = state;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.supervisor = supervisor;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(Employee emp) {
		List<GrantedAuthority> authorities = emp.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());

		return new UserDetailsImpl(
				emp.getEmpID(), 
				emp.getName(), 
				emp.getEmail(),
				emp.getAge(), 
				emp.getGender(), 
				emp.getPassword(), 
				emp.getAddress(), 
				emp.getCity(), 
				emp.getState(), 
				emp.getMobileNumber(), 
				emp.getSupervisor(), 
				
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	
	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDetailsImpl other = (UserDetailsImpl) obj;
		return Objects.equals(address, other.address) && age == other.age
				&& Objects.equals(authorities, other.authorities) && Objects.equals(city, other.city)
				&& Objects.equals(email, other.email) && empID == other.empID && Objects.equals(gender, other.gender)
				&& Objects.equals(mobileNumber, other.mobileNumber) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(state, other.state)
				&& Objects.equals(supervisor, other.supervisor);
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}


}