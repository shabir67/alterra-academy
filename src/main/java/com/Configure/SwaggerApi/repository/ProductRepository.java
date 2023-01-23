package com.Configure.SwaggerApi.repository;

import com.Configure.SwaggerApi.entitiy.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
