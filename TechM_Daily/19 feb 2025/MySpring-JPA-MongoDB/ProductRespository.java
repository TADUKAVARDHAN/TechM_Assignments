package com.web.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.web.model.Product;
import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByVendorCode(String vendorCode); 
}
