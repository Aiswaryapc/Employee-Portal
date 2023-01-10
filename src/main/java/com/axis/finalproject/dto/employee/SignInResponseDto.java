package com.axis.finalproject.dto.employee;

import java.io.Serializable;

public class SignInResponseDto implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = -3317678343294305536L;
	//private String status;
	 private final String jwttoken;
	public SignInResponseDto(String jwttoken) {
		super();
		
		this.jwttoken = jwttoken;
	}

	public String getJwttoken() {
		return jwttoken;
	}
		
}
