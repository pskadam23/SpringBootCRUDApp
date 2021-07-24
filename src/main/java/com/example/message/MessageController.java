package com.example.message;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MessageController {
	
	private final MessageRepository repository;

	MessageController(MessageRepository repository) {
	    this.repository = repository;
	  }


	  @GetMapping("/messages")
	  List<Message> all() {
	    return repository.findAll();
	  }


	  @PostMapping("/messages")
	  Message newMessage(@RequestBody Message newMessage) {
		  String filePath = newMessage.getText();
		  String newMessageText = ResourceReader.readFileToString(filePath);
		  if (newMessageText.length() > 255 ) 
			  throw new MessageLengthExceedsException();
		  else
			  return repository.save(new Message(newMessageText));
	  }

	  
	  @GetMapping("/messages/{id}")
	  Message one(@PathVariable Long id) {
	    return repository.findById(id).orElseThrow(() -> new MessageNotFoundException(id));
	  }

	  @PutMapping("/messages/{id}")
	  Message replaceMessage(@RequestBody Message newMessage, @PathVariable Long id) {
		  if (newMessage.getText().length() > 255)
			  throw new MessageLengthExceedsException();
		  else
			  return repository.findById(id)
	      .map(message -> {
	    	  message.setText(newMessage.getText());
	        return repository.save(message);
	      })
	      .orElseThrow(() -> new MessageNotFoundException(id));
//	      .orElseGet(() -> {
//	    	  newMessage.setId(id);
//	        return repository.save(newMessage);
//	      });
	  }

	  @DeleteMapping("/messages/{id}")
	  void deleteMessage(@PathVariable Long id) {
	    repository.deleteById(id);
	  }	
}
