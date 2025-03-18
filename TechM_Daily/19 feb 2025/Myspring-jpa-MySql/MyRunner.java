package com.app.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.app.model.Product;
import com.app.repo.ProductRepository;
import com.app.repo.ProductRepository.MyView;

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
                String idInput = sc.nextLine();
                if (idInput.equalsIgnoreCase("exit")) break;
                int id = Integer.parseInt(idInput);

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

                // Save Product
                repo.save(new Product(id, vendorCode, prodName, prodCost));
                System.out.println("Product Saved Successfully!\n");
            }

            System.out.print("Enter Vendor Code to fetch products: ");
            String vendorSearch = sc.nextLine();
            List<MyView> products = repo.findByVendorCode(vendorSearch);

            if (products.isEmpty()) {
                System.out.println("No products found for Vendor Code: " + vendorSearch);
            } else {
                System.out.println("\nProducts under Vendor Code '" + vendorSearch + "':");
                for (MyView p : products) {
                    System.out.println(p.getVendorCode() + " | " + p.getProdName() + " | " + p.getProdCost());
                }
            }
        } finally {
            sc.close(); 
        }
    }
}
