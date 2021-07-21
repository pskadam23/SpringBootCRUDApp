package com.example.message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

	private List<Message> messages = new ArrayList<>(
			Arrays.asList(
					new Message(1,"Hello world"),
					new Message(2,"Sample text"),
					new Message(3,"Demo app")
					)
			);
	
	
	public String getMessage(Long id) {
		return messages.stream().filter(t -> t.getId().equals(id)).findFirst().get().getText();
	}
	
	public List<Message> getAllMessages() {
		return messages;
	}
	
}
