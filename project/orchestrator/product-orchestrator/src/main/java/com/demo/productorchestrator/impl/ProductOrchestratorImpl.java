package com.demo.productorchestrator.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.store.SimpleMessageStore;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.demo.productorchestrator.Interface.IProductOrchestrator;


@EnableIntegration
@Service("productOrchestratorImpl")
public class ProductOrchestratorImpl implements IProductOrchestrator {
	
	@Autowired
	SimpleMessageStore productMessageStore;

	@Override
	public Message processInboundMessage(Message<?> payload) throws Exception {
		System.out.println("Inside messageToGetMetada");
		List metadataListMap = null;
		LinkedMultiValueMap map = new LinkedMultiValueMap();
		UUID jmsId = null;
		Message metadataMessage = null;
		try {
			metadataListMap = (List) payload.getPayload();
			System.out.println(metadataListMap);
			metadataMessage = MessageBuilder.withPayload(metadataListMap).build();
			jmsId  = metadataMessage.getHeaders().getId();
			this.productMessageStore.addMessage(metadataMessage);
			return MessageBuilder.withPayload(metadataListMap).setHeader("jmsId", jmsId).build();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Message printMessageUsingJmsId(Message<?> payload) throws Exception {
		MultiValueMap map = new LinkedMultiValueMap();
	    Map  metaDataMap= null;
	    String message = null;
	    try {
	     //UUID Id = (UUID)payload.getHeaders().get("jmsId");
	      //metaDataMap = (Map)this.productMessageStore.getMessage(Id).getPayload();
	    	 metaDataMap = (Map)payload.getPayload();
	      System.out.println("print .... "+metaDataMap);
	      metaDataMap.put("isExpired", "true");
	     map.add("metaData", metaDataMap);
	      return MessageBuilder.withPayload(map)
	    		  .build();
	    } catch (Exception e) {
	      e.printStackTrace();
	  
	    }
	    return null;
	}
	

	@Override
	public Message getProductData(Message<?> payload) throws Exception {
		MultiValueMap map = new LinkedMultiValueMap();
	    Map  metaDataMap= null;
	    Message<Map> message = null; 
	    try {
	    	metaDataMap = (Map<String, String>) payload.getPayload();
	    	message = MessageBuilder.withPayload(metaDataMap).build();
			UUID jmsId  = message.getHeaders().getId();
			return MessageBuilder.withPayload(metaDataMap).setHeader("jmsId", jmsId).build();
			   
	    }catch(Exception e) {
	    	
	    }
	    
	    return null;
		   }
	
	public void dummymethod(Message<?> payload) {
	}
	
	
	
}
