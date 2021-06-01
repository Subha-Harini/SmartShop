package com.demo.scheduledproductservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.demo.resuable.dataaccesslayer.entities.Product;
import com.demo.resuable.dataaccesslayer.repository.interfaces.ProductRepository;

@Service
public class ProductService {
	
	
	@Autowired
	@Lazy
	private ProductRepository productRepository;
	
	
	@Transactional
	public List<Map> getExpiredProductMap(String date){
		List<Map> productListMap = new ArrayList();
		
		try {
		List<Product> productList  = this.productRepository.getExpiredProducts(date);
		System.out.println(productList.toString());
		for(Product pd: productList) {
			Map product = new HashMap();
			product.put("productName",pd.getName());
			product.put("productCode", pd.getCode());
			product.put("expirationDate",pd.getDateOfExpiry().toString() );
			product.put("isExpired",pd.isExpired());
			productListMap.add(product);
		}
		System.out.println(productListMap);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return productListMap;
	}
	
	
	@Transactional
	public Map updateExpiryFlag(Map<String, String> metaData){
		System.out.println(metaData);
		try {
			Product product = this.productRepository.findByCode(Integer.parseInt((String)metaData.get("productCode")));
			System.out.println((String)metaData.get("isExpired"));
			System.out.println(metaData.get("isExpired").equals("true") ? true : false);
			product.setExpired(metaData.get("isExpired").equals("true") ? true : false);
			this.productRepository.saveAndFlush(product);
		
		}catch(Exception e) {
			throw e;
		}
		return metaData;
		
	}

}
