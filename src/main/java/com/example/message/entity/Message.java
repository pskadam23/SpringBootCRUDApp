package com.example.message;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Message {
	
	private @Id @GeneratedValue Long id;
	private String text;
	
	Message() {}

	Message(String text) {
	    this.text = text;
	  }

	public Long getId() {
		return this.id;
	}

	public String getText() {
		return this.text;
	}


	public void setId(Long id) {
		this.id = id;
	}

	  public void setText(String text) {
	    this.text = text;
	  }

	  @Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof Message))
	      return false;
	    Message message = (Message) o;
	    return Objects.equals(this.id, message.id) && Objects.equals(this.text, message.text);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.id, this.text);
	  }

	  @Override
	  public String toString() {
	    return "Message{" + "id=" + this.id + ", text='" + this.text + '\'' + '}';
	  }
}
