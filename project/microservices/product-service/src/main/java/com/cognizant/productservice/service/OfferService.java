package com.cognizant.productservice.service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.productservice.exception.OfferAlreadyExistsException;
import com.cognizant.productservice.model.Offer;
import com.cognizant.productservice.model.Product;
import com.cognizant.productservice.repository.OfferRepository;
import com.cognizant.productservice.repository.ProductRepository;

@Service
public class OfferService {
	@Autowired
	OfferRepository offerRepository;
	
	@Autowired
	ProductRepository productRepository;
	
    public OfferService(OfferRepository offerRepository) {
		super();
		this.offerRepository = offerRepository;
	}

	public void addOffer(Offer offer) throws OfferAlreadyExistsException {
    Optional<Offer> offer1 = offerRepository.getOffer(offer.getOfferDate(), offer.getProductCode());
    	if(offer1.isPresent()) {
    		throw new OfferAlreadyExistsException();
    	}
    	else {
    		offerRepository.save(offer);
    	}
    }
    
    public void updateOffer(Offer offer) {
        
        		offerRepository.save(offer);
        	
      }
    
    public List<Offer> getAllOffers(){
    	return offerRepository.findAll();
    }
    
    public List<Offer> getOffersByDate(Date date) throws ParseException{
    	
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    	String dateString = format.format( date   );
    	Date date1 = format.parse (dateString);    
    	return offerRepository.findByOfferDate(date1);
    }
    public List<Offer> getOffersByCurrentDate() throws ParseException{
    	
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    	String dateString = format.format(new Date());
    	Date date1 = format.parse (dateString);    
    	return offerRepository.findByOfferDate(date1);
    }
    
    public Offer getOfferByOfferId(int id) {
    	return offerRepository.findById(id).get();
    }
    
    public void deleteOffer(int id) {
    	offerRepository.deleteById(id);
    }
   
}
