package com.axis.finalproject.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.axis.finalproject.entity.ProfileImage;
import com.axis.finalproject.service.ProfileImageService;



@RequestMapping("/api/test/")
@RestController
@CrossOrigin("http://localhost:3000")
public class ProfileImageController {

	@Autowired
	private ProfileImageService profileImageService;


	  @GetMapping("/employee/profile-image/{userId}")
	  public ResponseEntity<Resource> getEmployeeProfileImageById(@PathVariable String userId) {
		  ProfileImage profileImage = profileImageService.getEmployeeProfileImageById(userId); return ResponseEntity.ok()
	  .contentType(MediaType.parseMediaType(profileImage.getFileType()))
	  .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +
	  profileImage.getFileName() + "\"") .body(new
	  ByteArrayResource(profileImage.getData())); 
		  }
	  
	  
	  @GetMapping("/stakeholder/profile-image/{userId}") public ResponseEntity<Resource>
	  getStakeholderProfileImageById(@PathVariable String userId) { ProfileImage profileImage
	  = profileImageService.getStakeHolderProfileImageById(userId); return ResponseEntity.ok()
	  .contentType(MediaType.parseMediaType(profileImage.getFileType()))
	  .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +
	  profileImage.getFileName() + "\"") .body(new
	  ByteArrayResource(profileImage.getData())); }
	 


	@PostMapping("/employee/profile-image/add")
	public ResponseEntity<String> addEmployeeProfileImage(@RequestParam("userId") String userId,
			@RequestParam("file") MultipartFile file) {
		profileImageService.addEmployeeProfileImage(userId, file);
		return new ResponseEntity<>("Profile Image Uploaded Successfully", HttpStatus.OK);
	}

	@PostMapping("/stakeholder/profile-image/add")
	public ResponseEntity<String> addStakeHolderProfileImage(@RequestParam("userId") String userId,
			@RequestParam("file") MultipartFile file) {
		profileImageService.addStakeholderProfileImage(userId, file);
		return new ResponseEntity<>("Profile Image Uploaded Successfully", HttpStatus.OK);
	}
}
