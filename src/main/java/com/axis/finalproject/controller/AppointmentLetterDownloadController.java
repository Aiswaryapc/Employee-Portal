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

import com.axis.finalproject.entity.AppointmentLetter;
import com.axis.finalproject.service.AppointmentLetterService;

@RestController
@RequestMapping("/api/test/")
public class AppointmentLetterDownloadController {
	@Autowired
	private AppointmentLetterService appointmentLetterService;

	@GetMapping("/downloadAppointmentLetter/{empId}")
	public ResponseEntity < Resource > downloadFile(@PathVariable int empId, HttpServletRequest request) {

		AppointmentLetter appointmentLetter = appointmentLetterService.getflie(empId);
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(appointmentLetter.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + appointmentLetter.getFileName() + "\"")
				.body(new ByteArrayResource(appointmentLetter.getData()));
	}
}


