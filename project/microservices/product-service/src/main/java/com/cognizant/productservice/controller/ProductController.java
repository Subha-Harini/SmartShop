package com.cognizant.productservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.productservice.ProductServiceApplication;
import com.cognizant.productservice.model.Product;
import com.cognizant.productservice.service.ProductService;

@RestController
@RequestMapping("/smart-shop/products")
public class ProductController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceApplication.class);
	@Autowired
	ProductService productService;


	@PostMapping
	public void addProduct(@RequestBody @Valid Product product) {
		LOGGER.info("Start");
		productService.addProduct(product);
		LOGGER.info("End");
	}

	@GetMapping
	public List<Product> getAllProducts() {
		LOGGER.info("Start");
		return productService.getAllProducts();
	}
	
	@GetMapping("/{code}")
	public Product getProduct(@PathVariable int code) {
		LOGGER.info("Start");
		return productService.getProduct(code);
	}
	
	@GetMapping("/sort-by-availability")
	public List<Product> sortByAvailability() {
		LOGGER.info("Start");
		return productService.sortByAvailability();
	}
	
	@GetMapping("/sort-by-name")
	public List<Product> sortByName() {
		LOGGER.info("Start");
		return productService.sortByName();
	}
	
	@GetMapping("/sort-by-popularity")
	public List<Product> sortByPopularity() {
		LOGGER.info("Start");
		return productService.getSortByPopularity();
	}
	
	@GetMapping("/sort-by-price")
	public List<Product> sortByPrice() {
		LOGGER.info("Start");
		return productService.sortByPrice();
	}
	
	@PutMapping
	public void updateProduct(@RequestBody @Valid Product product) {
		LOGGER.info("Start");
		productService.addProduct(product);
		LOGGER.info("End");
	}
	
	@DeleteMapping("/{code}")
	public void deleteProduct(@PathVariable int code) {
		LOGGER.info("Start");
		productService.deleteProduct(code);
		LOGGER.info("End");
	}
}
