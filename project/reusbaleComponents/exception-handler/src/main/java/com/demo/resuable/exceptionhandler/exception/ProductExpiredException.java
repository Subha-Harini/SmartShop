package com.demo.resuable.exceptionhandler.exception;

@SuppressWarnings("serial")
public class ProductExpiredException extends Exception {

	public ProductExpiredException() {
		super("Product Expired");
	}
}
