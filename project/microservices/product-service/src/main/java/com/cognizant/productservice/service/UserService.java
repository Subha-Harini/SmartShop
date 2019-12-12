package com.cognizant.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.productservice.model.User;
import com.cognizant.productservice.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Transactional
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Transactional
	public User getUserByID(String userId) {
		System.out.println(userRepository.findByUserId(userId));
		return userRepository.findByUserId(userId);
	}

	@Transactional
	public boolean userExists(String userId) {
		return userRepository.existsByUserId(userId);
	}
	
	@Transactional
	public List<User> getAllCustomers() {
		return userRepository.findAllByUserType();
	}
	

}
