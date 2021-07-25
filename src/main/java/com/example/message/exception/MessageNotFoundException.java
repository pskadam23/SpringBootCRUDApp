package com.example.message.exception;

public class MessageNotFoundException extends RuntimeException {

	/**
	 * Runtime exception raised when message with give Id is not found the in-memory database.
	 */
	private static final long serialVersionUID = 1L;

	public MessageNotFoundException(Long id) {
	    super("Could not find message with Id = " + id);
	}
}