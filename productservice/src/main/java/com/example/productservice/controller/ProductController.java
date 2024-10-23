package com.example.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productservice.models.Product;
import com.example.productservice.service.ProductService;



@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        try {
            Product viewProduct = productService.createProduct(product);

            return ResponseEntity.status(HttpStatus.CREATED).body(viewProduct);

        } catch (Exception e) {
            System.out.println("ERROR ARE FOUND IN PRODUCT-CONTROLLER" + e.getMessage());
            return null;
        }

    }

    @PostMapping("/getProduct")
    public ResponseEntity<Product> getSingleProduct(@PathVariable String productId) {
        try {
            Product viewProduct = productService.getSingleProduct(productId);

            return ResponseEntity.status(HttpStatus.CREATED).body(viewProduct);

        } catch (Exception e) {
            System.out.println("ERROR ARE FOUND IN PRODUCT-CONTROLLER" + e.getMessage());
            return null;
        }

    }

    @PostMapping("/allProducts")
    public ResponseEntity<List<Product>> listOfAllProduct() {
        try {
            List<Product> viewProduct = productService.listOfAllProduct();

            return ResponseEntity.status(HttpStatus.CREATED).body(viewProduct);

        } catch (Exception e) {
            System.out.println("ERROR ARE FOUND IN PRODUCT-CONTROLLER" + e.getMessage());
            return null;
        }

    }

}
