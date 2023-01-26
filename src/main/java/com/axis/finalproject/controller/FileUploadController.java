package com.axis.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.axis.finalproject.entity.SalarySlip;
import com.axis.finalproject.response.Response;
import com.axis.finalproject.service.SalarySlipService;
@RestController
@RequestMapping("/api/test/")
public class FileUploadController {
	 @Autowired
	    private SalarySlipService fileStorageService;
	 

	    @PostMapping("/uploadSalarySlip")
	    public Response uploadFile(@RequestParam("empId") int empId, @RequestParam("file") MultipartFile file) {
	        SalarySlip fileName = fileStorageService.storeFile(empId,file);

	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	            .path("/downloadFile/")
	            .path(fileName.getFileName())
	            .toUriString();

	        return new Response(fileName.getFileName(), fileDownloadUri,
	            file.getContentType(), file.getSize());
	    }

//	    @PostMapping("/uploadMultipleSalarySlips")
//	    public List < Response > uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
//	        return Arrays.asList(files)
//	            .stream()
//	            .map(file -> uploadFile(file))
//	            .collect(Collectors.toList());
//	    }
}
