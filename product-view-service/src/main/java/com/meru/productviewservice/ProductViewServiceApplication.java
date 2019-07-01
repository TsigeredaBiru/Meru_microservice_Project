package com.meru.productviewservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;





@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.meru.productviewservice")
public class ProductViewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductViewServiceApplication.class, args);
	}

}
