package com.example.message.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.message.entity.Message;
import com.example.message.exception.MessageLengthExceedsException;
import com.example.message.exception.MessageNotFoundException;
import com.example.message.filereader.ResourceReader;
import com.example.message.repository.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
	private final MessageRepository repository;
	
	MessageService(MessageRepository repository) {
	    this.repository = repository;
	}
	
	public List<Message> all() {
	    return repository.findAll();
	}
	
	public Message findMessagebyId(Long id) {
		return repository.findById(id).orElseThrow(() -> new MessageNotFoundException(id));
	}
	
	public Message newMessage(Message newMessage) {
		String filePath = newMessage.getText();
		String newMessageText = ResourceReader.readFileToString(filePath);
		if (newMessageText.length() > 255 ) 
			throw new MessageLengthExceedsException();
		else
			return repository.save(new Message(newMessageText));
	}

	public Message replaceMessage(Message newMessage,Long id) {
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

	public void deleteMessage(Long id) {
		repository.deleteById(id);
	}	
}
