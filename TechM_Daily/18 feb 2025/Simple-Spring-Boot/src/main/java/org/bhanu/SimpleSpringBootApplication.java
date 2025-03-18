package org.bhanu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleSpringBootApplication.class, args);
		System.out.println("Hello");
	}

}
