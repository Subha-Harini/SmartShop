package com.cognizant.productservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cognizant.productservice.security.AppUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	AppUserDetailsService appUserDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder());
	}


	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().httpBasic().and().authorizeRequests()
				.antMatchers("/smart-shop/products").authenticated()
				.antMatchers("/smart-shop/offers").authenticated()
				.antMatchers("/smart-shop/offers/{id}").authenticated()
				.antMatchers("/smart-shop/offers-by-date").authenticated()
				.antMatchers("/smart-shop/offers-by-date/{date}").authenticated()
				.antMatchers("/smart-shop/products/{code}").authenticated()
				.antMatchers("/smart-shop/bills").authenticated()
				.antMatchers("/smart-shop/bills/{id}").authenticated()
				.antMatchers("/smart-shop/user-bills/{userId}").authenticated()
				.antMatchers("/smart-shop/users/customers").authenticated()
				.and().addFilter(new JwtAuthorizationFilter(authenticationManager()));
		httpSecurity.cors();
	}
}
