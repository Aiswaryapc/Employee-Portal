package com.axis.finalproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.finalproject.entity.IncrementLetter;
import com.axis.finalproject.entity.JoiningLetter;
import com.axis.finalproject.service.IncrementLetterService;

@RestController
@RequestMapping("/api/test/")
public class IncrementLetterDownloadController {
	
	@Autowired
	private IncrementLetterService incrementLetterService;

	@GetMapping("/downloadIncrementLetter/{empId}")
	public ResponseEntity < Resource > downloadFile(@PathVariable int empId, HttpServletRequest request) {

		IncrementLetter joiningLetter = incrementLetterService.getflie(empId);
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(joiningLetter.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + joiningLetter.getFileName() + "\"")
				.body(new ByteArrayResource(joiningLetter.getData()));
	}
}
