package com.axis.finalproject.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class ProfileImage {

	@Id
	private String fileName;
	private String fileType;
	private String employeeId;
	private String stakeHolderId;

	@Lob
	private byte[] data;

	public ProfileImage() {
		
	}


	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}



	public String getStakeHolderId() {
		return stakeHolderId;
	}

	public void setStakeHolderId(String stakeHolderId) {
		this.stakeHolderId = stakeHolderId;
	}
	
	
}
