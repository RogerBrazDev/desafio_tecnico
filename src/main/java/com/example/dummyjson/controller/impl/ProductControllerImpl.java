package com.example.dummyjson.controller.impl;

import com.example.dummyjson.controller.ProductController;
import com.example.dummyjson.dto.Product;
import com.example.dummyjson.service.ProductService;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductControllerImpl implements ProductController {

    private final ProductService productService;

    public ProductControllerImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Flux<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @Override
    public Mono<Product> getProductById(Long id) {
        return productService.getProductById(id);
    }
}