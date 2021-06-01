package com.demo.productorchestrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication
@EnableIntegration
@ImportResource({"classpath:product-config-orch.xml","classpath:scheduled-product-service-activemq-config.xml"})
public class ProductOrchestratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductOrchestratorApplication.class, args);
	}

}
