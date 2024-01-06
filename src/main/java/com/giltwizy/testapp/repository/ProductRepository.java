package com.giltwizy.testapp.repository;

import com.giltwizy.testapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByProductName(String productName);
}
