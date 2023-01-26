package com.axis.finalproject.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.axis.finalproject.entity.JoiningLetter;
import com.axis.finalproject.exceptions.FileStorageException;
import com.axis.finalproject.repository.AppointmentLetterRepository;
import com.axis.finalproject.repository.JoiningLetterrepository;

@Service
public class JoiningLetterService {
	@Autowired
	private JoiningLetterrepository joiningLetterrepository;
	
	public JoiningLetter storeFile(int empId,MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
			}
			JoiningLetter dbFile= new JoiningLetter(empId, fileName, file.getContentType(), file.getBytes());
			return joiningLetterrepository.save(dbFile);
	}catch (IOException ex) {
		throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
	}
		

}

	public JoiningLetter getflie(int empId) {
		// TODO Auto-generated method stub
		return joiningLetterrepository.findByEmpId(empId);
	}
}
