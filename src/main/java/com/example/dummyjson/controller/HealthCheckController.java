package com.example.dummyjson.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Tag(name = "HealthCheck",
        description = "Endpoint para verificar a saúde do microsserviço") // Grupo no Swagger
@RequestMapping("/api/health")
public interface HealthCheckController {

    @Operation(
            summary = "Verifica a saúde do microsserviço",
            description = "Retorna o status do microsserviço"
    )
    @GetMapping
    ResponseEntity<Map<String, String>> healthCheck();
}
