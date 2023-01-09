package com.axis.finalproject.dto.employee;

public class SignInResponseDto {
	 private String status;
	   // private String token;
		public SignInResponseDto() {
			super();
		}
		public SignInResponseDto(String status ){
			super();
			this.status = status;
			//this.token = token;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
//		public String getToken() {
//			return token;
//		}
//		public void setToken(String token) {
//			this.token = token;
//		}
//	    
}
