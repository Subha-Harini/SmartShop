package com.cognizant.smartshop.signupservice.controller;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.smartshop.signupservice.SignupServiceApplication;
import com.cognizant.smartshop.signupservice.exception.UserAlreadyExistsException;
import com.cognizant.smartshop.signupservice.model.User;
import com.cognizant.smartshop.signupservice.service.UserService;


@RestController
@RequestMapping("/smart-shop/users") 
public class UserController {
	
      private static final Logger LOGGER = LoggerFactory.getLogger(SignupServiceApplication .class);
	
	  @Autowired
	  UserService userService;
	  
	  @Autowired
	  PasswordEncoder passwordEncoder;
	  
	  @PostMapping 
	  public void signUp(@RequestBody @Valid User user) throws UserAlreadyExistsException {
		  LOGGER.info("Start");
		  user.setPassword(passwordEncoder.encode(user.getPassword()));
		  userService.signUp(user);
		  LOGGER.info("End");
	 }
	  
	  @GetMapping
	  public List<User> getUsers() {
		 return userService.getUser();
	  }
	   @Bean
	    public PasswordEncoder passwordEncoder() {
	        LOGGER.info("Start");
	        return new BCryptPasswordEncoder();
	    }
	    
	  
	  @GetMapping("/pending-users")
	  public List<User> getAllPendingUserRequests() {
		 return userService.getAllPendingUsers();
	  }

	  @PutMapping("/pending-users/approve/{userId}")
	  public void approveUser(@PathVariable @Valid String userId) throws UserAlreadyExistsException {
		  LOGGER.info("Start");
		  userService.approveUser(userId);
		  LOGGER.info("End");
	 }
	  
	  @PutMapping("/pending-users/decline/{userId}")
	  public void declineUser(@PathVariable @Valid String userId) throws UserAlreadyExistsException {
		  LOGGER.info("Start");
		  userService.declineUser(userId);
		  LOGGER.info("End");
	 }
	  
	  @GetMapping("/{userId}")
	  public User getUser(@PathVariable @Valid String userId) {
		  LOGGER.info("Start");
		  return userService.getUserByUserId(userId);
	  }
	  
	  @GetMapping("/contact/{contactNumber}")
	  public User getUserByContactNumber(@PathVariable @Valid long contactNumber) {
		  LOGGER.info("Start");
		  return userService.getUserByContactNumnber(contactNumber);
	  }
	  
	  @PutMapping("/new-password")
		public void updatePassword(@RequestBody @Valid User user)  {
			LOGGER.info("Start");
			String password = user.getPassword();
			user.setStatus("A");
			user.setPassword(passwordEncoder.encode(password));
			System.out.println(user);
			userService.updateUser(user);
			LOGGER.info("End");
		}
	  
	   
}
