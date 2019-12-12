package com.cognizant.productservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.productservice.model.User;
import com.cognizant.productservice.repository.UserRepository;


@Service
public class AppUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		AppUser appUser = null;
		User user = userRepository.findByUserId(userId);
		if(user == null) {
			throw new UsernameNotFoundException(userId);
		}
		else {
			appUser = new AppUser(user);
		}
		return appUser;
	}

}
