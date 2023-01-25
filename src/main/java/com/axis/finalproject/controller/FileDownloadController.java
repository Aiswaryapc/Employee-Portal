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

import com.axis.finalproject.entity.DatabaseFile;
import com.axis.finalproject.service.DatabaseFileService;
@RestController
@RequestMapping("/api/test/")
public class FileDownloadController {
	@Autowired
	private DatabaseFileService fileStorageService;
	 @GetMapping("/downloadFile/{fileId:.+}")
	    public ResponseEntity < Resource > downloadFile(@PathVariable String fileId, HttpServletRequest request) {
	        // Load file as Resource
	        DatabaseFile databaseFile = fileStorageService.getFile(fileId);

	        return ResponseEntity.ok()
	            .contentType(MediaType.parseMediaType(databaseFile.getFileType()))
	            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + databaseFile.getFileName() + "\"")
	            .body(new ByteArrayResource(databaseFile.getData()));
	    }
}
