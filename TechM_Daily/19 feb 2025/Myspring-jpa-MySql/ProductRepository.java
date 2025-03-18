package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.model.Product;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    interface MyView {
        String getVendorCode();
        String getProdName();
        Double getProdCost();
    }

    @Transactional(readOnly = true)
    List<MyView> findByVendorCode(String vendorCode);
}
