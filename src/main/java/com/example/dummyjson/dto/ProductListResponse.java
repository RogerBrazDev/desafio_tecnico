package com.example.dummyjson.dto;

import java.util.List;

public class ProductListResponse {
    private List<Product> products;

    // Getter e Setter
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
