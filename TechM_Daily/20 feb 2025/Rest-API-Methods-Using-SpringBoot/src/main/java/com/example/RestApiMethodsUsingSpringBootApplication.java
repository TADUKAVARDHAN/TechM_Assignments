package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiMethodsUsingSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiMethodsUsingSpringBootApplication.class, args);
		System.out.println("Methods are called");
	}

}
