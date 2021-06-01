package com.cognizant.smartshop.signupservice.test;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.cognizant.smartshop.signupservice.controller.UserController;
import com.demo.resuable.dataaccesslayer.entities.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class SignupMockmvcTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private UserController userController;
	
	@Test
	public void getAllUsers() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/smart-shop/users")).andExpect(status().isOk());
	}
	
	@Test
    public void newUser() throws Exception {
       mockMvc.perform(MockMvcRequestBuilders
    		      .post("/smart-shop/users")
    		      .content(asJsonString(new User(0,"bb","bb",21,"Male",1234991244,"abc","a","A","P","what is your Nick name","bb","what is your favorite food","bb","what is your favorite holiday spot","bb")))
    		      .contentType(MediaType.APPLICATION_JSON)
    		      .accept(MediaType.APPLICATION_JSON))
    		      .andExpect(status().isOk());
    }
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	@Test
	public void getAllPendingUsers() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/smart-shop/users/pending-users")).andExpect(status().isOk());
	}
	

}
