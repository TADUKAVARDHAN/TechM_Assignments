package com.app.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.model.My_product;

@Repository
public interface ProductRepository extends JpaRepository<My_product,Integer> {

}
