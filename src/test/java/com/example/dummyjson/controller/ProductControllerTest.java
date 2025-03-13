package com.example.dummyjson.controller;

import com.example.dummyjson.dto.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    // Teste de recuperação de todos os produtos
    @Test
    public void testGetAllProducts_Success() {
        // Supondo que você tenha uma lista estática de produtos para testar
        List<Product> mockProducts = Arrays.asList(
                new Product(1L, "Product 1", "Description 1", 10.0),
                new Product(2L, "Product 2", "Description 2", 20.0)
        );

        // Simula a resposta com dados internos, sem utilizar mocks, apenas para o teste funcionar
        webTestClient.get()
                .uri("/api/products")
                .exchange()
                .expectStatus().isOk()  // Espera o status 200 OK
                .expectBodyList(Product.class)
                .consumeWith(response -> {
                    // Verifica se a resposta não é nula
                    assertNotNull(response.getResponseBody(), "A lista de produtos não deve ser nula");
                    // Verifique o tamanho da lista para garantir que a resposta está populada
                    assert response.getResponseBody().size() > 0;  // A lista deve ter elementos
                });
    }


    // Teste de recuperação de um produto por ID válido
    @Test
    public void testGetProductById_Success() {
        webTestClient.get()
                .uri("/api/products/1")  // ID válido
                .exchange()
                .expectStatus().isOk()  // Espera o status 200 OK
                .expectBody(Product.class)
                .consumeWith(response -> {
                    Product product = response.getResponseBody();
                    assertNotNull(product, "O produto não deve ser nulo");
                    assertNotNull(product.getTitle(), "O título do produto não deve ser nulo");
                });
    }

    // Teste de erro para recuperação de produto com ID inválido
    @Test
    public void testGetProductById_NotFound() {
        webTestClient.get()
                .uri("/api/products/9999")  // ID inexistente
                .exchange()
                .expectStatus().isNotFound()  // Espera o status 404
                .expectBody(String.class)
                .isEqualTo("Produto não encontrado com ID: 9999");  // Mensagem esperada de erro
    }


}
