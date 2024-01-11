package com.lipe.copilote.repository;

import com.lipe.copilote.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
