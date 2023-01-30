package com.axis.finalproject.controller;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.axis.finalproject.entity.Document;
import com.axis.finalproject.service.DocumentService;



@RestController
@RequestMapping("/api/test")
@CrossOrigin(value = "http://localhost:3000")
public class DocumentController {
	
	@Autowired
	private DocumentService documentService;

	@GetMapping("/document/{documentId}")
	public ResponseEntity<byte[]> getDocumentById(@PathVariable String documentId) {
		Document document = documentService.getDocumentById(documentId);
		return new ResponseEntity<>(Base64.getEncoder().encode(document.getFileData()), HttpStatus.OK);
	}
	@GetMapping("/documents")
	public List<String> getAllDocumentName(){
		return documentService.getDocuments();
	}
	
	@GetMapping("/documents/names")
	public List<Document> getAllDocumentNames(){
		return documentService.getDocumentnames();
	}
	
	
	
	
	@PostMapping("/add-document")
	public ResponseEntity<String> addDocument(@RequestParam("documentId") String documentId,
			@RequestParam("file") MultipartFile file) {
		documentService.addDocument(documentId, file);
		return new ResponseEntity<>("Document Uploaded Successfully..!!", HttpStatus.OK);
	}
}