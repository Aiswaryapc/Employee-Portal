package com.axis.finalproject.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	@Column (name = "employee_UID")
	 private int empID;
	 private String name;
	 private String Gender;
	 private int age;
	 private String address;
	 private String city;
	 private String state;
	 private int mobileNumber;
	 private String email;
	 private String password;
	 
	 
public Employee(){
	
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
	return Gender;
}


public void setGender(String gender) {
	Gender = gender;
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


public int getMobileNumber() {
	return mobileNumber;
}


public void setMobileNumber(int mobileNumber) {
	this.mobileNumber = mobileNumber;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


@Override
public String toString() {
	return "Employee [empID=" + empID + ", name=" + name + ", Gender=" + Gender + ", age=" + age + ", address="
			+ address + ", city=" + city + ", state=" + state + ", mobileNumber=" + mobileNumber + ", email=" + email
			+ ", password=" + password + "]";
}


@Override
public int hashCode() {
	return Objects.hash(Gender, address, age, city, email, empID, mobileNumber, name, password, state);
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Employee other = (Employee) obj;
	return Objects.equals(Gender, other.Gender) && Objects.equals(address, other.address) && age == other.age
			&& Objects.equals(city, other.city) && Objects.equals(email, other.email) && empID == other.empID
			&& mobileNumber == other.mobileNumber && Objects.equals(name, other.name)
			&& Objects.equals(password, other.password) && Objects.equals(state, other.state);
}


}
