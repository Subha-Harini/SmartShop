package com.demo.scheduledproductservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableDiscoveryClient
@EnableJpaRepositories("com.demo.resuable.dataaccesslayer.repository.interfaces")
@EntityScan("com.demo.resuable.dataaccesslayer.entities")
@ImportResource(value = {"classpath:scheduled-product-service-activemq-config.xml"})
//,"classpath:data-access-layer-config.xml"
public class ScheduledProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduledProductServiceApplication.class, args);
	}

}
