package com.axis.finalproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalDocumentExceptionHandler {

	@ExceptionHandler(value = DocumentNotFoundException.class)
	public ResponseEntity<String> handlerDocumentNotFoundException(DocumentNotFoundException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = DocumentInvalidException.class)
	public ResponseEntity<String> handlerDocumentInvalidException(DocumentInvalidException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}