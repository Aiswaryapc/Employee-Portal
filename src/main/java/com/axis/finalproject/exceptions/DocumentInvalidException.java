package com.axis.finalproject.exceptions;

public class DocumentInvalidException extends RuntimeException {

	private static final long serialVersionUID = -7760048L;

	public DocumentInvalidException() {
		super();
	}

	public DocumentInvalidException(String message, Throwable cause) {
		super(message, cause);
	}

	public DocumentInvalidException(String message) {
		super(message);
	}
}