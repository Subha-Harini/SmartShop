package com.cognizant.smartshop.signupservice.service;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.smartshop.signupservice.SignupServiceApplication;
import com.cognizant.smartshop.signupservice.exception.UserAlreadyExistsException;
import com.cognizant.smartshop.signupservice.model.User;
import com.cognizant.smartshop.signupservice.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	private static final Logger LOGGER = LoggerFactory.getLogger( SignupServiceApplication.class);
	
	@Override
	@Transactional
	public void signUp(User userObject) throws UserAlreadyExistsException {
	   LOGGER.info("Start");
	   User user = userRepository.findByUserId(userObject.getUserId());
	   if(user !=  null) {
		   throw new UserAlreadyExistsException("User already exists");
	   }
	   else {
		   userRepository.save(userObject);
	   }
	   LOGGER.info("End");
	}

	
	@Override
	public List<User> getAllPendingUsers() {
		List<User> user = new ArrayList<User>();
		user = userRepository.findAllByStatus();
		System.out.println(user);
		return user;
	}
	
	@Override
	public List<User> getUser() {
		return userRepository.findAll();
	}
    
	public void approveUser(String userId) {
		LOGGER.info("Start");
		 User user = userRepository.findByUserId(userId);
		 user.setStatus("A");
		 userRepository.save(user);
		 LOGGER.info("End");
	}
	@Override
	public void declineUser(String userId) {
		LOGGER.info("Start");
		 User user = userRepository.findByUserId(userId);
		 user.setStatus("D");
		 userRepository.save(user);
		 LOGGER.info("End");
		
	}
	
	public User getUserByUserId(String userId) {
		LOGGER.info("Start");
		 return userRepository.findByUserId(userId);
	
	}
	@Override
	public User getUserByContactNumnber(long number) {	
		return userRepository.findByContactNumber(number);
	}
	@Override
	public void updateUser(User user) {
		userRepository.save(user);
		
	}

	
}
