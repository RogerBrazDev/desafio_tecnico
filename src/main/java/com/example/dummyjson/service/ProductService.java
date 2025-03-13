package com.example.dummyjson.service;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.ProductListResponse;
import com.example.dummyjson.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    private final WebClient webClient;

    @Autowired
    public ProductService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<Product> getAllProducts() {
        return webClient.get()
                .uri("/products")
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> {
                    return response.bodyToMono(String.class)
                            .flatMap(errorMessage -> Mono.error(new RuntimeException("Erro no cliente: " + errorMessage)));
                })
                .onStatus(HttpStatusCode::is5xxServerError, response -> {
                    return response.bodyToMono(String.class)
                            .flatMap(errorMessage -> Mono.error(new RuntimeException("Erro no servidor: " + errorMessage)));
                })
                .bodyToMono(ProductListResponse.class)
                .flatMapMany(response -> {
                    if (response.getProducts() == null || response.getProducts().isEmpty()) {
                        return Flux.empty();
                    }
                    return Flux.fromIterable(response.getProducts());
                });
    }

    public Mono<Product> getProductById(Long id) {
        return webClient.get()
                .uri("/products/{id}", id)
                .retrieve()
                .bodyToMono(Product.class)
                .onErrorMap(e ->
                        new ProductNotFoundException("Produto não encontrado com ID: " + id)
                );
    }


}
