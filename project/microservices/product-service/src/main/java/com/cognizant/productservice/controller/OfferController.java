package com.cognizant.productservice.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.productservice.exception.OfferAlreadyExistsException;
import com.cognizant.productservice.model.Offer;
import com.cognizant.productservice.service.OfferService;

@RestController
@RequestMapping("/smart-shop")
public class OfferController {
	
	@Autowired
	OfferService offerService;
	
	@PostMapping("/offers")
	public void saveOffer(@RequestBody @Valid Offer offer) throws OfferAlreadyExistsException {
		offerService.addOffer(offer);
	}
	
	@GetMapping("/offers-by-date/{date}")
	public List<Offer> getOfferByDate(@PathVariable Date date) throws ParseException{
		return offerService.getOffersByDate(date);
	}
	
	@GetMapping("/offers-by-date")
	public List<Offer> getOfferByCurrentDate() throws ParseException{
		return offerService.getOffersByCurrentDate();
	}
	@GetMapping("/offers")
	public List<Offer> getOffers(){
		return offerService.getAllOffers();
	}
	
	@GetMapping("/offers/{id}")
	public Offer getOffers(@PathVariable int id){
		return offerService.getOfferByOfferId(id);
	}
	
	@PutMapping("/offers")
	public void updateOfferDetails(@RequestBody @Valid Offer offer){
		offerService.updateOffer(offer);
	}
	
	@DeleteMapping("/offers/{id}")
	public void deleteOffer(@PathVariable @Valid int id){
		offerService.deleteOffer(id);
	}
	
}
