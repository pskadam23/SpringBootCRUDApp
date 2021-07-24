package com.example.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	
	@Autowired
	private final MessageRepository repository;
	
	MessageService(MessageRepository repository) {
	    this.repository = repository;
	}
	
	List<Message> all() {
	    return repository.findAll();
	}
	
	Message findMessagebyId(Long id) {
		return repository.findById(id).orElseThrow(() -> new MessageNotFoundException(id));
	}
	
	Message newMessage(Message newMessage) {
		String filePath = newMessage.getText();
		String newMessageText = ResourceReader.readFileToString(filePath);
		if (newMessageText.length() > 255 ) 
			throw new MessageLengthExceedsException();
		else
			return repository.save(new Message(newMessageText));
	}

	Message replaceMessage(Message newMessage,Long id) {
		if (newMessage.getText().length() > 255)
			throw new MessageLengthExceedsException();
		else
			return repository.findById(id)
					.map(message -> {
						message.setText(newMessage.getText());
						return repository.save(message);
					})
					.orElseThrow(() -> new MessageNotFoundException(id));
	}

	void deleteMessage(Long id) {
		repository.deleteById(id);
	}	
}
