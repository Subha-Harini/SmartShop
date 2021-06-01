package com.demo.productorchestrator.Interface;

import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@EnableIntegration
@Service
public interface IProductOrchestrator {

	public Message processInboundMessage(Message<?> payload) throws Exception;
	public Message printMessageUsingJmsId(Message<?> payload) throws Exception;
	Message getProductData(Message<?> payload) throws Exception;
	
}
