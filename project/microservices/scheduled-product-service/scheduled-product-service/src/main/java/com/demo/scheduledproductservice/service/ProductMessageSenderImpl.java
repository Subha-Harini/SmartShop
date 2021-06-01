package com.demo.scheduledproductservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.JmsProperties.DeliveryMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demo.resuable.dataaccesslayer.entities.Product;



@Configuration
public class ProductMessageSenderImpl {

	

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public ActiveMQConnectionFactory getActivemqConnectionFactoryBean() {
		return activemqConnectionFactoryBean;
	}

	public void setActivemqConnectionFactoryBean(ActiveMQConnectionFactory activemqConnectionFactoryBean) {
		this.activemqConnectionFactoryBean = activemqConnectionFactoryBean;
	}

	
	private JmsTemplate jmsTemplate;
	
	private ActiveMQConnectionFactory activemqConnectionFactoryBean;
	
	
	
	public void sendMessageToQueue(List<Map> productListMap) {
		 try {
			
			 System.out.println("inside message to queue");
			 System.out.println(activemqConnectionFactoryBean.getUserName());
			 System.out.println(activemqConnectionFactoryBean.getPassword());
			 System.out.println(activemqConnectionFactoryBean.getBrokerURL());
			 activemqConnectionFactoryBean.createConnection(activemqConnectionFactoryBean.getUserName(), activemqConnectionFactoryBean.getPassword());
			//jmsTemplate.convertAndSend("expiryQueue", productListMap);
			 //for(int i=0; i<productListMap.size(); i++) {
				// 	Map map = productListMap.get(i);
				 	jmsTemplate.convertAndSend("expiryQueue", new ArrayList(productListMap), m -> {

		            m.setJMSCorrelationID(UUID.randomUUID().toString());
		            m.setJMSExpiration(1000);
		            m.setJMSMessageID("message-id");
		            m.setJMSDestination(new ActiveMQQueue("expiryQueue"));
		            m.setJMSReplyTo(new ActiveMQQueue("expiryQueue"));
		            m.setJMSPriority(0);
		            m.setJMSTimestamp(System.nanoTime());
		            m.setJMSType("type");

		            m.setStringProperty("service", "ProductService");
		            m.setBooleanProperty("jms-custom-property", true);
		            m.setDoubleProperty("jms-custom-property-price", 0.0);

		            return m;
		        });
			// }
		} catch (JMSException e) {
			e.printStackTrace();
		}
		 
	}
}
