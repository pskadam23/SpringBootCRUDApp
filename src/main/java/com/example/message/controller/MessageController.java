package com.example.message.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.message.entity.Message;
import com.example.message.service.MessageService;


@RestController
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	// Handles GET request
	@GetMapping("/messages")
	List<Message> allMessages() {
	    return messageService.all();
	}
	
	//Handles GET request with input Id
	@GetMapping("/messages/{id}")
	Message findMessagebyId(@PathVariable Long id) {
		return messageService.findMessagebyId(id);
	}

	@PostMapping("/messages")
	Message newMessage(@RequestBody Message newMessage) {
		return messageService.newMessage(newMessage);
	}
	  
	  @PutMapping("/messages/{id}")
	  Message replaceMessage(@RequestBody Message newMessage, @PathVariable Long id) {
		  return messageService.replaceMessage(newMessage, id);
	  }

	  @DeleteMapping("/messages/{id}")
	  void deleteMessage(@PathVariable Long id) {
		  messageService.deleteMessage(id);
	  }	
}
