package com.example.message;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MessageLengthExceedsAdvice {
	
	@ResponseBody
	  @ExceptionHandler(MessageLengthExceedsException.class)
	  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	  String MessageLengthExceedsHandler(MessageLengthExceedsException ex) {
	    return ex.getMessage();
	  }

}
