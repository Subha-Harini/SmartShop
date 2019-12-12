package com.cognizant.smartshop.signupservice.model;

import java.util.Date;

public class MyError {
	
	private String errorDescription;
	private String errorMessage;
	private Date time;
	
	public MyError() {
		super();
	}
	public MyError(String errorMessage,String description,  Date time) {
		super();
		this.errorDescription = description;
		this.errorMessage = errorMessage;
		this.time = time;
	}
	public String getErrorCode() {
		return errorDescription;
	}
	public void setErrorCode(String errorCode) {
		this.errorDescription = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	
	
}
