package com.example.RedisTest.service.impl;

import com.example.RedisTest.entity.Product;
import com.example.RedisTest.repository.ProductRepository;
import com.example.RedisTest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productReposipory;

    @Override
    public Product saveProduct(Product product) {
        return productReposipory.save(product);
    }

    @Override
    @CachePut(value = "Product",key = "#productId")
    public Product updateProduct(Product product, String productId) {
        product.setProductId(productId);
        return productReposipory.save(product);
    }

    @Override
    @CacheEvict(value = "Product",key = "#productId")
    public void deleteProduct(String productId) {
        productReposipory.deleteById(productId);
    }

    @Override
    @Cacheable(value = "Product" , key = "#productId")
    public Optional<Product> getOneProduct(String productId) {
        System.out.println("databaseCall");
        return productReposipory.findById(productId);
    }

    @Override
    @Cacheable(value = "Product")
    public List<Product> getAllProducts() {
        System.out.println("databaseCallGetAllProducts");
        return productReposipory.findAll();

    }
}
