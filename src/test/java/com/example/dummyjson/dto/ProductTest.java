package com.example.dummyjson.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    public void testGettersAndSetters() {
        // Arrange: Valores esperados
        Long expectedId = 1L;
        String expectedTitle = "A dummy title";
        String expectedDescription = "A dummy description";
        Double expectedPrice = 2.1;

        // Act: Cria um objeto Product e define os valores
        Product product = new Product();
        product.setId(expectedId);
        product.setTitle(expectedTitle);
        product.setDescription(expectedDescription);
        product.setPrice(expectedPrice);

        // Assert: Verifica se os valores foram atribuídos corretamente
        assertEquals(expectedId, product.getId(), "O ID do produto deve ser 1");
        assertEquals(expectedTitle, product.getTitle(), "O título do produto deve ser 'A dummy title'");
        assertEquals(expectedDescription, product.getDescription(), "A descrição do produto deve ser 'A dummy description'");
        assertEquals(expectedPrice, product.getPrice(), "O preço do produto deve ser 2.1");
    }
}