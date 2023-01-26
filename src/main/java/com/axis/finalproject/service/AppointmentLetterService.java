package com.axis.finalproject.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.axis.finalproject.entity.AppointmentLetter;
import com.axis.finalproject.entity.SalarySlip;
import com.axis.finalproject.exceptions.FileStorageException;
import com.axis.finalproject.repository.AppointmentLetterRepository;

@Service
public class AppointmentLetterService {

	@Autowired
	private AppointmentLetterRepository appointmentLetterRepository;

	public AppointmentLetter storeFile(int empId, MultipartFile file) {

		// Normalize file name
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
			}
			AppointmentLetter dbFile=new AppointmentLetter(empId, fileName, file.getContentType(), file.getBytes());
			return appointmentLetterRepository.save(dbFile);
		}catch (IOException ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

	public AppointmentLetter getflie(int empId) {
		// TODO Auto-generated method stub
		return appointmentLetterRepository.findByEmpId(empId);
	}
}

