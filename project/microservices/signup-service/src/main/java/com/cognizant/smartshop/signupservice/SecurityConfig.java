package com.cognizant.smartshop.signupservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


@Configuration 
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SignupServiceApplication.class);
	
	    @Override
	    protected void configure(HttpSecurity httpSecurity) throws Exception {
	    	  LOGGER.info("Start");
	    	 httpSecurity.cors();
	         httpSecurity.csrf().disable().httpBasic().and()
	         .sessionManagement()
	         .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	         .and()
	         .authorizeRequests()
	         .antMatchers("/smart-shop/users").anonymous()
	         .antMatchers("/smart-shop/users/new-password").anonymous()
	         .antMatchers("/smart-shop/users/{userId}").anonymous()
	         .antMatchers("/smart-shop/users/contact/{contactNumber}").anonymous()
	         .antMatchers("/smart-shop/users/pending-users").anonymous()
	         .antMatchers("/smart-shop/users/pending-users/approve/{userId}").authenticated()
	         .antMatchers("/smart-shop/users/pending-users/decline/{userId}").authenticated()
	         .and().addFilter(new JwtAuthorizationFilter(authenticationManager()));
	         LOGGER.info("End");
	    }
}
