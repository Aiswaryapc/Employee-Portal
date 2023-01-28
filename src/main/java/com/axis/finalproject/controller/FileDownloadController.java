package com.axis.finalproject.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.finalproject.entity.SalarySlip;
import com.axis.finalproject.service.SalarySlipService;
@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/test/")
public class FileDownloadController {
	@Autowired
	private SalarySlipService fileStorageService;
	 @GetMapping("/downloadSalarySlip/{empId}")
	    public ResponseEntity < Resource > downloadFile(@PathVariable int empId, HttpServletRequest request) {
	        // Load file as Resource
	        SalarySlip salarySlip = fileStorageService.getFile(empId);

	        return ResponseEntity.ok()
	            .contentType(MediaType.parseMediaType(salarySlip.getFileType()))
	            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + salarySlip.getFileName() + "\"")
	            .body(new ByteArrayResource(salarySlip.getData()));
	    }
}
