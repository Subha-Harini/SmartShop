package com.cognizant.productservice.test;

import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 import org.springframework.boot.test.context.SpringBootTest;

 import com.demo.resuable.dataaccesslayer.entities.Product;
 import com.demo.resuable.dataaccesslayer.repository.interfaces.ProductRepository;
import com.cognizant.productservice.service.ProductService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
 import org.junit.runner.RunWith;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ProductMockitoTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductMockitoTest.class);
	 ProductRepository repository = Mockito.mock(ProductRepository.class);
	 ProductService service = new ProductService(repository);
	 
	 
	@Test
 	public void addProduct() {
 		LOGGER.info("Start");
 		Product product = new Product(12, "potato", 1, "fresh",224, 10 , 12 , new Date(), "1" ," 2" ,new Date(), new Date(),"");
 		when(repository.save(product)).thenReturn(null);
 		service.addProduct(product);
 		LOGGER.info("End");
 
 	}
	
	/*@Test
 	public void deleteProduct() {
 		LOGGER.info("Start");
 		int code = 2;
 		when(repository.deleteByCode(code)).thenReturn(null);
 		service.deleteProduct(code);
 		LOGGER.info("End");
 
 	}*/

	 
		@Test
	 	public void getAllProducts() {
	 		LOGGER.info("Start");
	 		Product product = new Product(12, "potato", 1, "fresh",224, 10 , 12 , new Date(), "1" ," 2" ,new Date(), new Date(),"");
	 		List<Product> products = new ArrayList<Product>();
	 		products.add(product);
	 		List<Product> expected = products;
	 		when(repository.findAllProductAvailable()).thenReturn(products);
	 		boolean flag = false;
			for(int i=0 ;  i<products.size(); i++ ) {
				assertEquals(expected.get(i), products.get(i));
				
			}
	 		LOGGER.info("End");
	 
	 	}
		
		@Test
	 	public void getProduct() {
	 		LOGGER.info("Start");
	 		int code = 2;
	 		when(repository.findByCode(code)).thenReturn(null);
	 		service.getProduct(code);
	 		LOGGER.info("End");
	 
	 	}
		

		@Test
	 	public void sortByPrice() {
	 		LOGGER.info("Start");
	 		Product product = new Product(12, "potato", 1, "fresh",224, 10 , 12 , new Date(), "1" ," 2" ,new Date(), new Date(),"");
	 		List<Product> products = new ArrayList<Product>();
	 		products.add(product);
	 		List<Product> expected = products;
	 		when(repository.getSortByPrice()).thenReturn(products);
	 		boolean flag = false;
			for(int i=0 ;  i<products.size(); i++ ) {
				assertEquals(expected.get(i), products.get(i));
				
			}
	 		LOGGER.info("End");
	 
	 	}
		
		
		@Test
	 	public void sortByName() {
	 		LOGGER.info("Start");
	 		Product product = new Product(12, "potato", 1, "fresh",224, 10 , 12 , new Date(), "1" ," 2" ,new Date(), new Date(),"");
	 		List<Product> products = new ArrayList<Product>();
	 		products.add(product);
	 		List<Product> expected = products;
	 		when(repository.getSortByName()).thenReturn(products);
	 		boolean flag = false;
			for(int i=0 ;  i<products.size(); i++ ) {
				assertEquals(expected.get(i), products.get(i));
				
			}
	 		LOGGER.info("End");
	 
	 	}
		
		@Test
	 	public void sortByAvailability() {
	 		LOGGER.info("Start");
	 		Product product = new Product(12, "potato", 1, "fresh",224, 10 , 12 , new Date(), "1" ," 2" ,new Date(), new Date(),"");
	 		List<Product> products = new ArrayList<Product>();
	 		products.add(product);
	 		List<Product> expected = products;
	 		when(repository.getSortByAvailability()).thenReturn(products);
	 		boolean flag = false;
			for(int i=0 ;  i<products.size(); i++ ) {
				assertEquals(expected.get(i), products.get(i));
				
			}
	 		LOGGER.info("End");
	 
	 	}
		
		@Test
	 	public void getProductByName() {
	 		LOGGER.info("Start");
	 		Product product = new Product(12, "potato", 1, "fresh",224, 10 , 12 , new Date(), "1" ," 2" ,new Date(), new Date(),"");
	 		Product expected = product;
	 		when(repository.findByName("potato")).thenReturn(product);
	 		assertEquals(expected, service.getProductByName("potato"));
	 		LOGGER.info("End");
	 
	 	}
		
		
		
	
}
