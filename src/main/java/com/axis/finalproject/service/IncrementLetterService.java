package com.axis.finalproject.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.axis.finalproject.entity.IncrementLetter;
import com.axis.finalproject.entity.JoiningLetter;
import com.axis.finalproject.exceptions.FileStorageException;
import com.axis.finalproject.repository.IncrementLetterRepository;

@Service
public class IncrementLetterService {

	@Autowired
	private IncrementLetterRepository incrementLetterRepository;

	public IncrementLetter storeFile (int empId, MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
			}
			IncrementLetter dbFile = new IncrementLetter(empId, fileName, file.getContentType(), file.getBytes());
			return incrementLetterRepository.save(dbFile);
		}catch (IOException ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

	public IncrementLetter getflie(int empId) {
		// TODO Auto-generated method stub
		return incrementLetterRepository.findByEmpId(empId);
	}

	
}
