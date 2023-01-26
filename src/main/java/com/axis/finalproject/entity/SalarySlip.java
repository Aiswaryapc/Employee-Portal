package com.axis.finalproject.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "files")
public class SalarySlip {
	
	    @Id
	    @GeneratedValue(generator = "uuid")
	    @GenericGenerator(name = "uuid", strategy = "uuid2")
	    private String id;
	    
	    private int empId;
	 

	    private String fileName;

	    private String fileType;

	    @Lob
	    private byte[] data;
	    

		public SalarySlip() {
			super();
		}


		


		public SalarySlip(int empid, String fileName, String fileType, byte[] data) {
			super();
			this.empId = empid;
			this.fileName = fileName;
			this.fileType = fileType;
			this.data = data;
		}





		public String getId() {
			return id;
		}





		public void setId(String id) {
			this.id = id;
		}





		public int getEmpid() {
			return empId;
		}





		public void setEmpid(int empid) {
			this.empId = empid;
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





		

}
