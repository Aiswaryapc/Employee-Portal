package com.axis.finalproject.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.axis.finalproject.entity.SalarySlip;
import com.axis.finalproject.exceptions.FileNotFoundException;
import com.axis.finalproject.exceptions.FileStorageException;
import com.axis.finalproject.repository.SalarySlipRepository;

@Service
public class SalarySlipService {
	
	@Autowired
	private SalarySlipRepository dbFileRepository;
	
	  public SalarySlip storeFile(int empId, MultipartFile file) {
	        // Normalize file name
	        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

	        try {
	            // Check if the file's name contains invalid characters
	            if (fileName.contains("..")) {
	                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
	            }

	            SalarySlip dbFile = new SalarySlip(empId, fileName, file.getContentType(), file.getBytes());

	            return dbFileRepository.save(dbFile);
	        } catch (IOException ex) {
	            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
	        }
	    }

	public SalarySlip getFile(int empId ) {
	
		return dbFileRepository.findByEmpId(empId);
//				.orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
		
	}

//	    public SalarySlip getFile(String fileId) {
//	        return dbFileRepository.findById(fileId);
//	           
//	    }

}
