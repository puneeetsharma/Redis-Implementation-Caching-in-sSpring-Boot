package com.example.RedisTest.service;

import com.example.RedisTest.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public Product saveProduct(Product product);
    public Product updateProduct(Product product, String productId);
    public void deleteProduct(String productId);
    public Optional<Product> getOneProduct(String productId);
    public List<Product> getAllProducts();
}
