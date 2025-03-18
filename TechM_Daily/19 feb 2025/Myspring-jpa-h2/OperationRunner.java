package com.app.repo.impl;

import java.util.Optional;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.app.model.My_product;
import com.app.repo.ProductRepository;

@Component
public class OperationRunner implements CommandLineRunner {
    @Autowired
    private ProductRepository repo;
    
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add a new product");
            System.out.println("2. Search for a product by ID");
            System.out.println("3. View all products");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); 
            
            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter product price: ");
                    double price = sc.nextDouble();
                    sc.nextLine(); 
                    
                    System.out.print("Enter product color: ");
                    String color = sc.nextLine();
                    
                    My_product product = new My_product(name, price, color);
                    repo.save(product);
                    System.out.println("Product saved successfully!");
                    break;
                    
                case 2:
                    System.out.print("Enter product ID to search: ");
                    int id = sc.nextInt();
                    
                    Optional<My_product> p = repo.findById(id);
                    if (p.isPresent()) {
                        System.out.println("Product found: " + p.get());
                    } else {
                        System.out.println("No data found.");
                    }
                    break;
                    
                case 3:
                   
                    System.out.println("\nAll Products in Database:");
                    repo.findAll().forEach(System.out::println);
                    break;

                case 4:
                  
                    System.out.println("Exiting the application.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        sc.close();
    }
}
