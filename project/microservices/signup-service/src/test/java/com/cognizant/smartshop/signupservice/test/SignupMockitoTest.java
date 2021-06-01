package com.cognizant.smartshop.signupservice.test;

import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
 import org.junit.runner.RunWith;

import com.demo.resuable.dataaccesslayer.entities.User;
import com.demo.resuable.dataaccesslayer.repository.interfaces.UserRepository;
import com.demo.resuable.exceptionhandler.exception.UserAlreadyExistsException;
import com.cognizant.smartshop.signupservice.service.UserServiceImpl;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class SignupMockitoTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(SignupMockitoTest.class);
	 UserRepository repository = Mockito.mock(UserRepository.class);
	 UserServiceImpl service = new UserServiceImpl(repository);
	 
	 	@Test(expected = UserAlreadyExistsException.class)
	 	public void testForUserExist() throws UserAlreadyExistsException {
	 		LOGGER.info("Start");
	 		User user = new User(10,"Harini","Kannan",23,"female", 766767666, "787878", "paswrd", "U","A", "what is your first school name?", "sankara", "what is your mother's name?", "subha" , "what is your favorite color?" , "red");
	 		when(repository.findByUserId("787878")).thenReturn(user);
	 		service.signUp(user);
	 		LOGGER.info("End");
	 	}
	 	@Test
	 	public void newSignUp() throws UserAlreadyExistsException {
	 		LOGGER.info("Start");
	 		when(repository.findByUserId("787878")).thenReturn(null);
	 		User user = new User(10,"Harini","Kannan",23,"female", 766767666, "787878", "paswrd", "U","A", "what is your first school name?", "sankara", "what is your mother's name?", "subha" , "what is your favorite color?" , "red");
	 		service.signUp(user);
	 		LOGGER.info("End");
	 
	 	}
	
	 	@Test
	 	public void getPendingUsers() {
	 		LOGGER.info("Start");
	 		when(repository.findAllByStatus()).thenReturn(createUserList());
	 		List<User> userList = service.getAllPendingUsers();
			boolean flag = false;
			for(User item:userList) {
				User user = item;
				String expected ="P";
				assertEquals(expected, user.getStatus());
				
			}
	 		LOGGER.info("End");
	 
	 	}
	 	
	 	List<User>	createUserList(){
	 		List<User> users = new ArrayList<User>(); 			
	 		User user = new User(10,"Harini","Kannan",23,"female", 766767666, "787878", "paswrd", "A","P", "what is your first school name?", "sankara", "what is your mother's name?", "subha" , "what is your favorite color?" , "red");
	 		User user2 = new User(11,"Hari","Kannan",23,"female", 766767606, "781212", "paswrd", "A","P", "what is your first school name?", "sankara", "what is your mother's name?", "subha" , "what is your favorite color?" , "red");
	 		users.add(user);
	 		users.add(user2);
	 		return users;
	 	}
	 	
	 	@Test
	 	public void getAllUsers() {
	 		LOGGER.info("Start");
	 		List<User> expectedList = createUserList();
	 		when(repository.findAll()).thenReturn(createUserList());
	 		List<User> userList = service.getUser();
			boolean flag = false;
			for(int i=0 ;  i<userList.size(); i++ ) {
				assertEquals(expectedList.get(i), userList.get(i));
				
			}
	 		LOGGER.info("End");
	 
	 	}
	 	
	 	@Test
	 	public void getUserApproved() {
	 		LOGGER.info("Start");
	 		String userId = "787878";
	 		User user = new User(10,"Harini","Kannan",23,"female", 766767666, "787878", "paswrd", "A","P", "what is your first school name?", "sankara", "what is your mother's name?", "subha" , "what is your favorite color?" , "red");
	 		when(repository.findByUserId("787878")).thenReturn(user);
	 		when(repository.save(user)).thenReturn(null);
	 		service.approveUser(userId);
	 		LOGGER.info("End");
	 
	 	}
	 	
	 	@Test
	 	public void getUserDeclined() {
	 		LOGGER.info("Start");
	 		String userId = "787878";
	 		User user = new User(10,"Harini","Kannan",23,"female", 766767666, "787878", "paswrd", "A","P", "what is your first school name?", "sankara", "what is your mother's name?", "subha" , "what is your favorite color?" , "red");
	 		when(repository.findByUserId("787878")).thenReturn(user);
	 		when(repository.save(user)).thenReturn(null);
	 		service.declineUser(userId);
	 		LOGGER.info("End");
	 
	 	}
	 	
	 	@Test
	 	public void getUserByUserId() {
	 		LOGGER.info("Start");
	 		String userId = "787878";
	 		User user = new User(10,"Harini","Kannan",23,"female", 766767666, "787878", "paswrd", "A","P", "what is your first school name?", "sankara", "what is your mother's name?", "subha" , "what is your favorite color?" , "red");
	 		when(repository.findByUserId("797878")).thenReturn(user);
	 		service.getUserByUserId(userId);
	 		LOGGER.info("End");
	 
	 	}
	 	
	 	@Test
	 	public void updateUser() {
	 		LOGGER.info("Start");
	 		User user = new User(10,"Harini","Kannan",23,"female", 766767666, "787878", "paswrd", "A","P", "what is your first school name?", "sankara", "what is your mother's name?", "subha" , "what is your favorite color?" , "red");
	 		when(repository.save(user)).thenReturn(null);
	 		service.updateUser(user);
	 		LOGGER.info("End");
	 
	 	}
	 	
		@Test
	 	public void getUserByContactNumber() {
	 		LOGGER.info("Start");
	 		long contact = 766767666;
	 		User user = new User(10,"Harini","Kannan",23,"female", 766767666, "787878", "paswrd", "A","P", "what is your first school name?", "sankara", "what is your mother's name?", "subha" , "what is your favorite color?" , "red");
	 		when(repository.findByContactNumber(766767666)).thenReturn(user);
	 		service.getUserByContactNumnber(contact);
	 		LOGGER.info("End");
	 
	 	}
	 
}
