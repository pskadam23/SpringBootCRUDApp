package com.example.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@RequestMapping("/messages")
	public List<Message> getAllMessages() {
		return messageService.getAllMessages();
	}
	
	@RequestMapping("/messages/{id}")
	public String getMessage(@PathVariable  Long id) {
		
		return messageService.getMessage(id);
	}

}
