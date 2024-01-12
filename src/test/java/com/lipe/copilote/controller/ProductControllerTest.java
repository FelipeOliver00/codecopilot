package com.lipe.copilote.controller;

import com.lipe.copilote.model.Product;
import com.lipe.copilote.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @Test
    public void testGetProducts() {
        when(productService.getAllProducts()).thenReturn(List.of(new Product(1L, "DESK", "LITTLE DESK", 1)));
        var products = productController.getProducts();
        Assertions.assertEquals("LITTLE DESK", products.get(0).getDescription());
    }

    @Test
    public void testGetProductById(){
        when(productService.getProductById(1L)).thenReturn(new Product(1L, "DESK", "LITTLE DESK", 1));
        var product = productController.getProduct(1L);
        Assertions.assertEquals("DESK", product.getName());
    }

    @Test
    public void testAddProduct(){
        Product product = new Product(1L, "DESK", "LITTLE DESK", 1);
        Assertions.assertEquals("Product added successfuly", productController.addProduct(product));
    }

    @Test
    public void testDeleteProduct(){
        var product = productController.deleteProduct(1L);
        Assertions.assertEquals("Product deleted successfuly", product);
    }

}