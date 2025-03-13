package com.example.dummyjson.controller;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.ProductListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import jakarta.validation.constraints.NotNull;

@RequestMapping("/api/products")
@Tag(name = "Produtos", description = "API para gerenciamento de produtos") // Grupo no Swagger
public interface ProductController {

    @Operation(
            summary = "Buscar todos os produtos",
            description = "Retorna uma lista de produtos. Se não houver produtos, retorna um HTTP 204 (No Content). " +
                    "Se ocorrer algum erro ao buscar os produtos, um erro será retornado.",
            responses = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            responseCode = "200",
                            description = "Lista de produtos retornada com sucesso",
                            content = @io.swagger.v3.oas.annotations.media.Content(
                                    mediaType = "application/json",
                                    schema = @io.swagger.v3.oas.annotations.media.Schema(
                                            implementation = ProductListResponse.class)
                            )
                    ),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            responseCode = "204",
                            description = "Nenhum produto encontrado",
                            content = @io.swagger.v3.oas.annotations.media.Content(
                                    mediaType = "application/json",  // Aqui, indicamos que o corpo é uma string
                                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = String.class)
                            )
                    ),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            responseCode = "500",
                            description = "Erro ao buscar produtos",
                            content = @io.swagger.v3.oas.annotations.media.Content(
                                    mediaType = "application/json",
                                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = String.class)
                            )
                    )
            }
    )
    @GetMapping
    Flux<Product> getAllProducts();

    @Operation(
            summary = "Buscar produto por ID",
            description = "Retorna um único produto pelo ID. Se o produto não for encontrado, retorna um erro 404 (Not Found). Se ocorrer algum erro ao buscar o produto, um erro será retornado.",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "ID do produto a ser buscado",
                            required = true,
                            example = "123"
                    )
            },
            responses = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            responseCode = "200",
                            description = "Produto encontrado com sucesso",
                            content = @io.swagger.v3.oas.annotations.media.Content(
                                    mediaType = "application/json",
                                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = Product.class)
                            )
                    ),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            responseCode = "404",
                            description = "Produto não encontrado"
                    ),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            responseCode = "500",
                            description = "Erro ao buscar o produto"
                    )
            }
    )
    @GetMapping("/{id}")
    Mono<Product> getProductById(
            @PathVariable @NotNull Long id);  // Alteração aqui, usando @PathVariable
}
