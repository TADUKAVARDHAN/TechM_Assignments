package com.example.rest.ftoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FtoCServer {
	public static void main(String args[]) {
		System.setProperty("spring.config.name","FtoCServer");
		SpringApplication.run(FtoCServer.class, args);
	}
}
