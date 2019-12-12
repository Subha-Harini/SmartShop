package com.cognizant.smartshop.signupservice.service;

import java.util.List;

import com.cognizant.smartshop.signupservice.exception.UserAlreadyExistsException;
import com.cognizant.smartshop.signupservice.model.User;

public interface UserService {
	
	public void signUp(User user) throws UserAlreadyExistsException;
	public List<User> getUser() ;
	public List<User> getAllPendingUsers();
	public void approveUser(String userId);
	public void declineUser(String userId);
	public User getUserByUserId(String userId);
	public User getUserByContactNumnber(long number);
	public void updateUser(User user);
}
