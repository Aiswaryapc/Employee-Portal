package com.axis.finalproject.service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.axis.finalproject.entity.Document;
import com.axis.finalproject.exceptions.DocumentInvalidException;
import com.axis.finalproject.exceptions.DocumentNotFoundException;
import com.axis.finalproject.repository.DocumentRepository;

@Service
public class DocumentService {

	@Autowired
	private DocumentRepository documentRepository;

	public Document getDocumentById(String documentId) {
		return documentRepository.findById(documentId).orElseThrow(() -> new DocumentNotFoundException("Document Requested By Document Id " + documentId + "Not Exists.."));
	}
	public List<String> getDocuments(){
		
		List<Document> docList = documentRepository.findAll();
		ArrayList<String> nameList = new ArrayList<>();
		for(Document i:docList)
		{
			
			nameList.add(i.getdocumentName());
			
		}
		return nameList;
	}
	
	public List<Document> getDocumentnames(){
		
		return documentRepository.findAll();

	}
	public void addDocument(String documentId, MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if(fileName.contains("..")) {
				throw new DocumentInvalidException("File name is Invalid..Rename the file: " + fileName);
			}
			Document document = new Document(documentId, fileName, file.getContentType(), file.getBytes());
			documentRepository.save(document);
		} catch(IOException e) {
			throw new DocumentInvalidException("Error..Could not store file with name " + fileName + ". Please try again!");
		}		
	}

}