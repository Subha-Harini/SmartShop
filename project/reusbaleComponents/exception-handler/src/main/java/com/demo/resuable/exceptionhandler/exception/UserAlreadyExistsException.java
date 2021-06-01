package com.demo.resuable.exceptionhandler.exception;

public class UserAlreadyExistsException extends Exception {
	private String msg;

	public UserAlreadyExistsException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
