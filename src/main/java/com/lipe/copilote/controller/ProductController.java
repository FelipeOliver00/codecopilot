package com.lipe.copilote.controller;

import com.lipe.copilote.model.Product;
import com.lipe.copilote.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/products")
    public String addProduct(Product product) {
        productService.addProduct(product);
        return "Product added successfuly";
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(Long id) {
        productService.deleteProduct(id);
        return "Product deleted successfuly";
    }

}

