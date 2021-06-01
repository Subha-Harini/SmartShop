package com.demo.productorchestrator.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class Splitter {
	
	
	public List<Message<Map<String, String>>> split (Message payload){
		List<Message<Map<String, String>>> result = new LinkedList<>();
		try {
		List<Map<String, String>> map = (List<Map<String, String>>)payload.getPayload();
		for(Map<String, String> entry : map) {
			Message<Map<String,String>> message = MessageBuilder.withPayload(entry).build();
			result.add(message);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("result = "+result);
		return result;
	}
}
