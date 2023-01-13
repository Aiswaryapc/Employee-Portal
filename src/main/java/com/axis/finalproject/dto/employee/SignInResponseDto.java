package com.axis.finalproject.dto.employee;


import java.util.List;
import java.util.Set;

import com.axis.finalproject.entity.Role;

public class SignInResponseDto {
	
	private String token;
	 private String type = "Bearer";
	  private int id;
	  private String username;
	  private String email;
	  private Set<Role> roles;

	  public SignInResponseDto(String accessToken, int id, String username, String email, Set<Role> roles) {
	    this.token = accessToken;
	    this.id = id;
	    this.username = username;
	    this.email = email;
	    this.roles = roles;
	  }

	  public String getAccessToken() {
	    return token;
	  }

	  public void setAccessToken(String accessToken) {
	    this.token = accessToken;
	  }

	  public String getTokenType() {
	    return type;
	  }

	  public void setTokenType(String tokenType) {
	    this.type = tokenType;
	  }

	  public int getId() {
	    return id;
	  }

	  public void setId(int id) {
	    this.id = id;
	  }

	  public String getEmail() {
	    return email;
	  }

	  public void setEmail(String email) {
	    this.email = email;
	  }

	  public String getUsername() {
	    return username;
	  }

	  public void setUsername(String username) {
	    this.username = username;
	  }

	  public Set<Role> getRoles() {
	    return roles;
	  }
	}