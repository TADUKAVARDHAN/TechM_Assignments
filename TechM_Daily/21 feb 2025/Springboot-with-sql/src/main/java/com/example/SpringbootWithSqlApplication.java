package com.example;  // ✅ Ensure this matches your package

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootWithSqlApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootWithSqlApplication.class, args);
    }
}
