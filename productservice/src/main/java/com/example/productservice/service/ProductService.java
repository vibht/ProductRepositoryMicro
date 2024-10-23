package com.example.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productservice.Repository.ProductRepository;
import com.example.productservice.models.Product;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        try {
            Product pod = new Product();
            pod.setProductName(product.getProductName());
            pod.setProductPrice(product.getProductPrice());
            pod.setProductDescription(product.getProductDescription());

            return productRepository.save(pod);

        } catch (Exception e) {
            throw new UnsupportedOperationException("Unimplemented method 'createProduct'" + e.getMessage());
        }

    }

    public Product getSingleProduct(String productId) {
        try {
            Product pp = productRepository.findById(productId).get();
            Product specificProduct = new Product();
            specificProduct.getProductName();
            specificProduct.getProductPrice();
            specificProduct.getProductDescription();
            specificProduct.getProductId();

            return pp;

        } catch (Exception e) {
            throw new UnsupportedOperationException("Unimplemented method 'getsingleProduct'" + e.getMessage());
        }

    }

    public List<Product> listOfAllProduct() {
        try {
            return productRepository.findAll();

        } catch (Exception e) {
            throw new UnsupportedOperationException("Unimplemented method 'listOfAllProduct'" + e.getMessage());
        }

    }

}
