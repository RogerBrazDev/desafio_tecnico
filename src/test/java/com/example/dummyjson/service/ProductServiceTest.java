package com.example.dummyjson.service;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.exception.ProductNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private ProductService productService;

    // Configuração inicial se necessário
    @BeforeEach
    void setUp() {
        // Aqui você pode configurar dados iniciais se necessário
    }

    @Test
    void testGetAllProducts_Success() {
        // Faz uma requisição GET para o endpoint real
        webTestClient.get().uri("https://dummyjson.com/products")
                .exchange()
                .expectStatus().isOk() // Espera um HTTP 200
                .expectBodyList(Product.class)
                .value(products -> {
                    // Verifica se a lista de produtos não é nula nem vazia
                    assertTrue(products != null && !products.isEmpty(), "A lista de produtos não pode ser nula ou vazia");
                });
    }

    @Test
    void testGetProductById_Success() {
        // Supondo que você tenha um produto com ID 1 na base de dados
        webTestClient.get().uri("https://dummyjson.com/products/{id}", 1)
                .exchange()
                .expectStatus().isOk() // Espera HTTP 200
                .expectBody(Product.class)
                .value(product -> {
                    assertTrue(product.getId().equals(1L)); // Confirma que o ID do produto é 1
                });
    }

    @Test
    void testGetProductById_NotFound() {
        // Tenta pegar um produto com um ID que não existe
        webTestClient.get().uri("https://dummyjson.com/products/{id}", 9999)
                .exchange()
                .expectStatus().isNotFound(); // Espera HTTP 404
    }

}
