package com.example.RedisTest.controller;

import com.example.RedisTest.entity.Product;
import com.example.RedisTest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/saveProduct")
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/gatAllProducts")
    public ResponseEntity<List<Product>> gatAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/findProductById/{productId}")
    public ResponseEntity<Optional<Product>> findProductById(@PathVariable String productId) {
        Optional<Product> product= productService.getOneProduct(productId);
        return new ResponseEntity<Optional<Product>>(product,HttpStatus.OK);

    }

    @PutMapping("/updateProductDetails/{productId}")
    public Product updateProductDetails(@RequestBody Product product, @PathVariable String productId) {
        return productService.updateProduct(product, productId);
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable String productId) {
        productService.deleteProduct(productId);
        return "Employee with id: "+productId+ " Deleted !";
    }
}
