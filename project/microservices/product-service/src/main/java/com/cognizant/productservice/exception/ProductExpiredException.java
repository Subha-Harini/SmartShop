package com.cognizant.productservice.exception;

@SuppressWarnings("serial")
public class ProductExpiredException extends Exception {

	public ProductExpiredException() {
		super("Product Expired");
	}
}
