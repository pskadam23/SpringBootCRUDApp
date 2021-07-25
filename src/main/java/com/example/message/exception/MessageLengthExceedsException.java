package com.example.message;

public class MessageLengthExceedsException extends RuntimeException {
	
	/**
	 * Runtime exception raised when message length exceeds limit of 255 characters .
	 */	
	private static final long serialVersionUID = 1L;

	MessageLengthExceedsException() {
	    super("String length exceeds limit of 255 characters for given message");
	}

}
