package com.cognizant.finalcheck.authenticationservice.test;

import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 import org.springframework.boot.test.context.SpringBootTest;
 import org.springframework.security.core.userdetails.UserDetails;
 import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.demo.resuable.authorizationlayer.security.AppUserDetailsService;
import com.demo.resuable.dataaccesslayer.entities.User;
import com.demo.resuable.dataaccesslayer.repository.interfaces.UserRepository;

import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
 

 @RunWith(MockitoJUnitRunner.class)
 @SpringBootTest
public class AuthenticationMockitoTest {
	 private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationMockitoTest.class);
	 UserRepository repository = Mockito.mock(UserRepository.class);
	 AppUserDetailsService service = new AppUserDetailsService(repository);
	 
	 @Test
	 	public void mockTestLoadUserByUsername() {
	 		LOGGER.info("Start");
	 		when(repository.findByUserId("787878")).thenReturn(createUser());
	 		UserDetails user = service.loadUserByUsername("787878");
	 		String expected = "paswrd";
	 		assertEquals(expected, user.getPassword());
	 		LOGGER.info("End");
	 	}
	 
		private User createUser() {
	 		User user = new User(10,"Harini","Kannan",23,"female", 766767666, "787878", "paswrd", "U","A", "what is your first school name?", "sankara", "what is your mother's name?", "subha" , "what is your favorite color?" , "red");
	 		return user;
	 	}
		
		@Test(expected = UsernameNotFoundException.class)
	 	public void testLoadByUserNameNotFoundException() throws UsernameNotFoundException {
	 		when(repository.findByUserId("797872")).thenReturn(null);
	 		service.loadUserByUsername("797872");
	 	}
		
}	
