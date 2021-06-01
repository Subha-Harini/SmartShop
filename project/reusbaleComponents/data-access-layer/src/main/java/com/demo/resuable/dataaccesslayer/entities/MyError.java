package com.demo.resuable.dataaccesslayer.entities;

import java.util.Date;

public class MyError {
	private String message;
	private String description;
	private Date date;

	public MyError(String message, String description, Date date) {
		super();
		this.message = message;
		this.description = description;
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "MyError [message=" + message + ", description=" + description + ", date=" + date + "]";
	}

}
