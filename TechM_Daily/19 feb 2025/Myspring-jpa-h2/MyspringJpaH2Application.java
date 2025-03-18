package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyspringJpaH2Application {

	public static void main(String[] args) {
		SpringApplication.run(MyspringJpaH2Application.class, args);
		System.out.println("H2 Database App Started.");
	}

}
