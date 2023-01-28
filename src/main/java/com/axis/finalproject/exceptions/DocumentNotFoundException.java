package com.axis.finalproject.exceptions;

public class DocumentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7760047L;

	public DocumentNotFoundException() {
		super();
	}

	public DocumentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public DocumentNotFoundException(String message) {
		super(message);
	}
}
