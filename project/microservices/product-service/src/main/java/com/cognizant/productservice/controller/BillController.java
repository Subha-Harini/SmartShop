package com.cognizant.productservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cognizant.productservice.service.BillService;
import com.cognizant.productservice.service.UserService;
import com.demo.resuable.dataaccesslayer.entities.Bill;
import com.demo.resuable.dataaccesslayer.entities.User;
import com.demo.resuable.dataaccesslayer.entities.UserBill;
import com.demo.resuable.exceptionhandler.exception.ProductExpiredException;

@RestController
@RequestMapping("/smart-shop")
public class BillController {
	
	@Autowired
	BillService billService;
	
	@Autowired
	UserService userService;		
	 
	
	@GetMapping("/bills")
	List<Bill> getAllBills(){
		return billService.getAllBills();
	}
	
	@PostMapping("/bills")
	Bill postBills(@RequestBody @Valid UserBill userBill ) throws ProductExpiredException {
		return billService.userBills(userBill);
	}
	
	@GetMapping("/bills/{id}")
	Bill getBillByBillId(@PathVariable int id) {
		return billService.getBillByBillId(id);
	}
	 

	@GetMapping("/users/customers")
	public List<User> getAllCustomers() {
		return userService.getAllCustomers();
	}
	
	@GetMapping("/user-bills/{userId}")
	public List<Bill> getUserBills(@PathVariable int userId){
		return billService.getUserBills(userId);
	}
}
