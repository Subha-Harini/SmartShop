package com.demo.scheduledproductservice.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;

import com.demo.scheduledproductservice.service.ProductMessageSenderImpl;
import com.demo.scheduledproductservice.service.ProductService;

@RestController
@RequestMapping("/smart-shop")
public class ScheduledProductServiceController {
	
	@Autowired
	ProductMessageSenderImpl messageSenderImpl;
	
	@Autowired
	ProductService productService;
	
	//@Scheduled(cron = "0 17 * * * ?")
	@Scheduled(fixedRate = 1800000, initialDelay=0)
	public void getExpiredProducts() throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		  Date today = Calendar.getInstance().getTime();
		  String dateToString = df.format(today);
		System.out.println("started at = "+dateToString);
		List<Map> list = productService.getExpiredProductMap(dateToString);
		if(list.size() > 0) {
		messageSenderImpl.sendMessageToQueue(list);
		}
	}
	
	@PostMapping(value="/updateExpiryProducts")
	public ResponseEntity updateExpiryFlag(@RequestPart("metaData") Map<String, String> metaData) throws Exception {
		ResponseEntity response = null;
		Map result = null;
		try {
			result = this.productService.updateExpiryFlag(metaData);
			result.put("sentToExpiredQueue","true");
		}catch(Exception e) {
			e.printStackTrace();
			result = null;
			result.put("Exception", "true");
			result.put("ExceptionMessage", e.getMessage());
		}
		response = ResponseEntity.ok(result);
		return response;
	}
}
