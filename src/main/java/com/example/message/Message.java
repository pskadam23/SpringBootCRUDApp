package com.example.message;

import java.util.Objects;
import javax.persistence.Entity;

@Entity
public class Message {
	
	private Integer id;
	private String text;
	
	Message() {}

	Message(Integer id,String text) {
		this.id = id;
	    this.text = text;
	  }

	public Integer getId() {
		return this.id;
	}

	public String getText() {
		return this.text;
	}


	public void setId(Integer id) {
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
	    return Objects.equals(this.id, message.id);
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
