package com.demo.resuable.exceptionhandler.exception;

@SuppressWarnings("serial")
public class OfferAlreadyExistsException extends Exception {

	public OfferAlreadyExistsException() {
		super("Offer already exits for the selected product");
	}
}
