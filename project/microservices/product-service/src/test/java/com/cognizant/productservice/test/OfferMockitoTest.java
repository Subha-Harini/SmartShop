package com.cognizant.productservice.test;

import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 import org.springframework.boot.test.context.SpringBootTest;

import com.demo.resuable.dataaccesslayer.entities.Offer;
import com.demo.resuable.dataaccesslayer.repository.interfaces.OfferRepository;
import com.demo.resuable.exceptionhandler.exception.OfferAlreadyExistsException;
import com.cognizant.productservice.service.OfferService;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.runner.RunWith;
import org.junit.Test;;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class OfferMockitoTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(OfferMockitoTest.class);
	 OfferRepository repository = Mockito.mock(OfferRepository.class);
	 OfferService service = new OfferService(repository);
	 
	 
	 @Test
	 	public void getAllOffers() {
	 		LOGGER.info("Start");
	 		Offer offer = new Offer(1,new Date(), 12,12);
	 		List<Offer> offers = new ArrayList<Offer>();
	 		offers.add(offer);
	 		when(repository.findAll()).thenReturn(offers);
	 		List<Offer> offerList = service.getAllOffers();
			assertEquals(offers, service.getAllOffers());
	 		LOGGER.info("End");
	 
	 	}
	 
	 
	 @Test
	 	public void updateOffers() {
	 		LOGGER.info("Start");
	 		Offer offer = new Offer(1,new Date(), 12,12);
	 		when(repository.save(offer)).thenReturn(null);
	 		service.updateOffer(offer);
	 		LOGGER.info("End");
	 
	 	}
		@Test(expected = OfferAlreadyExistsException.class)
	 	public void testForUserExist() throws OfferAlreadyExistsException {
	 		LOGGER.info("Start");
	 		Offer offer = new Offer(1,new Date(), 12,12);
	 		when(repository.getOffer(new Date(), 1).get()).thenReturn(offer);
	 		when(repository.save(offer)).thenReturn(null);
	 		service.addOffer(offer);
	 		LOGGER.info("End");
	 	}
	 	@Test
	 	public void addoffer() throws OfferAlreadyExistsException {
	 		LOGGER.info("Start");
	 		Offer offer = new Offer(1,new Date(), 12,12);
	 		when(repository.getOffer(new Date(), 1).get()).thenReturn(null);
	 		when(repository.save(offer)).thenReturn(null);
	 		service.addOffer(offer);
	 		LOGGER.info("End");
	 
	 	}
	 
	/* @Test
	 	public void getOfferByOfferId() {
	 		LOGGER.info("Start");
	 		Offer offer = new Offer(1,new Date(), 12,12);
	 		int id = 1;
	 		when(repository.findById(id).get()).thenReturn(offer);
	 		assertEquals(offer, service.getOfferByOfferId(id));
	 		LOGGER.info("End");
	 
	 	}*/

	/* @Test
	 	public void deleteOffer() {
	 		LOGGER.info("Start");
	 		int id = 1;
	 		when(repository.deleteById(id)).thenReturn(null);
	 	    service.deleteOffer(id);;
	 		LOGGER.info("End");
	 
	 	}*/
	 

	 @Test
	 	public void getOfferByDate() throws ParseException {
	 		LOGGER.info("Start");
	 		Offer offer = new Offer(1,new Date(), 12,12);
	 		List<Offer> offerList = new ArrayList();
	 		offerList.add(offer);
	 		Date date = new Date();
	 		when(repository.findByOfferDate(date)).thenReturn(offerList);
	 		assertEquals(offerList, service.getOffersByDate(date));
	 		LOGGER.info("End");
	 
	 	}
	 
	 @Test
	 	public void getOfferByCurrentDate() throws ParseException {
	 		LOGGER.info("Start");
	 		Offer offer = new Offer(1,new Date(), 12,12);
	 		List<Offer> offerList = new ArrayList();
	 		offerList.add(offer);
	 		Date date = new Date();
	 		when(repository.findByOfferDate(date)).thenReturn(offerList);
	 		assertEquals(offerList, service.getOffersByDate(date));
	 		LOGGER.info("End");
	 
	 	}
}
