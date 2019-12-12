package com.cognizant.smartshop.signupservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.smartshop.signupservice.model.User;
import com.cognizant.smartshop.signupservice.repository.UserRepository;


@Service
public class AppUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	
	public AppUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}



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
