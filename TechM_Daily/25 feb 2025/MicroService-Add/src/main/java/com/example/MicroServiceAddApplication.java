package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroServiceAddApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceAddApplication.class, args);
		System.out.println("Server Executed");
	}

}
