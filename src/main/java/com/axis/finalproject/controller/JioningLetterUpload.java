package com.axis.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.axis.finalproject.entity.AppointmentLetter;
import com.axis.finalproject.entity.JoiningLetter;
import com.axis.finalproject.response.Response;
import com.axis.finalproject.service.JoiningLetterService;

@RestController
@RequestMapping("/api/test/")
public class JioningLetterUpload {
	
	@Autowired
	private JoiningLetterService joiningLetterService;
	
	@PostMapping("/uploadJoiningLetter")
    public Response uploadFile(@RequestParam("empId") int empId, @RequestParam("file") MultipartFile file) {
      JoiningLetter fileName = joiningLetterService.storeFile(empId,file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/downloadFile/")
            .path(fileName.getFileName())
            .toUriString();

        return new Response(fileName.getFileName(), fileDownloadUri,
            file.getContentType(), file.getSize());
    }

}
