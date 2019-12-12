package com.cognizant.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.productservice.model.Product;
import com.cognizant.productservice.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	
	
	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Transactional
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	

	@Transactional
	public void deleteProduct(int code) {
		productRepository.deleteByCode(code);
	}
	
	@Transactional
	public List<Product> getAllProducts() {
		return productRepository.findAllProductAvailable();
	}
	
	@Transactional
	public Product getProduct(int code) {
		return productRepository.findByCode(code);
	}
	
	@Transactional
	public List<Product> sortByName() {
		return productRepository.getSortByName();
	}
	
	@Transactional
	public List<Product> sortByPrice() {
		return productRepository.getSortByPrice();
	}
	
	@Transactional
	public List<Product> sortByAvailability() {
		return productRepository.getSortByAvailability();
	}

	@Transactional
	public Product getProductByName(String name) {
		return productRepository.findByName(name);
	}


	
	
	public List<Product> getSortByPopularity(){
		List<Product> productArray = productRepository.getProductArray1();
		productArray.addAll(productRepository.getProductArray2());
		System.out.println(productArray);
		return productArray;
	}

}
