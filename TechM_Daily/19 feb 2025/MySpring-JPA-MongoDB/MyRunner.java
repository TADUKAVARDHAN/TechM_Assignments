package com.web.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.web.model.Product;
import com.web.repo.ProductRepository;

import java.util.List;
import java.util.Scanner;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private ProductRepository repo;

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("\nEnter Product Details (or type 'exit' to stop):");

                System.out.print("Enter Product ID: ");
                String id = sc.nextLine();
                if (id.equalsIgnoreCase("exit")) break;

                System.out.print("Enter Vendor Code: ");
                String vendorCode = sc.nextLine();
                if (vendorCode.equalsIgnoreCase("exit")) break;

                System.out.print("Enter Product Name: ");
                String prodName = sc.nextLine();
                if (prodName.equalsIgnoreCase("exit")) break;

                System.out.print("Enter Product Cost: ");
                String costInput = sc.nextLine();
                if (costInput.equalsIgnoreCase("exit")) break;
                double prodCost = Double.parseDouble(costInput);

                repo.save(new Product(id, vendorCode, prodName, prodCost));
                System.out.println("Product Saved Successfully!\n");
            }

            System.out.print("Enter Vendor Code to fetch products: ");
            String vendorSearch = sc.nextLine();
            List<Product> products = repo.findByVendorCode(vendorSearch);

            if (products.isEmpty()) {
                System.out.println("No products found for Vendor Code: " + vendorSearch);
            } else {
                System.out.println("\n Products under Vendor Code '" + vendorSearch + "':");
                for (Product p : products) {
                    System.out.println(p);
                }
            }
        } finally {
            sc.close(); 
        }
    }
}
