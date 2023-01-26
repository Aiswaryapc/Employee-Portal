package com.axis.finalproject.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.axis.finalproject.entity.ProfileImage;
import com.axis.finalproject.exceptions.ProfileImageStorageException;
import com.axis.finalproject.repository.ProfileImageRepository;




@Service
public class ProfileImageService  {

	@Autowired
	private ProfileImageRepository profileImageRepository;

	
	public ProfileImage getEmployeeProfileImageById(String userId) {
		return profileImageRepository.findByemployeeId(userId);
	}
	public ProfileImage getStakeHolderProfileImageById(String userId) {
		return profileImageRepository.findBystakeHolderId(userId);
	}

	public void addEmployeeProfileImage(String userId, MultipartFile file) {
		Optional<ProfileImage> img= profileImageRepository.getByemployeeId(userId);
			if(img.isPresent()){
					profileImageRepository.deleteById(img.get().getFileName());}
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		try {
			if(fileName.contains("..")) {
				throw new ProfileImageStorageException("Filename contains Invalid Path Sequence" + fileName);
			}
			ProfileImage profileImage = new ProfileImage();
			profileImage.setEmployeeId(userId);
			profileImage.setFileName(fileName);
			profileImage.setFileType(file.getContentType());
			profileImage.setData(file.getBytes());
			profileImageRepository.save(profileImage);
		} catch(IOException e) {
			throw new ProfileImageStorageException("Could not store file " + fileName + ". Please try again!");
		}
	}
	
	public void addStakeholderProfileImage(String userId, MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if(fileName.contains("..")) {
				throw new ProfileImageStorageException("Filename contains Invalid Path Sequence" + fileName);
			}
			ProfileImage profileImage = new ProfileImage();
			profileImage.setStakeHolderId(userId);
			profileImage.setFileName(fileName);
			profileImage.setFileType(file.getContentType());
			profileImage.setData(file.getBytes());
			profileImageRepository.save(profileImage);
		} catch(IOException e) {
			throw new ProfileImageStorageException("Could not store file " + fileName + ". Please try again!");
		}
	}
	
	
	
}
