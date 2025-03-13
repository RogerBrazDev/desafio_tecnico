package com.example.dummyjson.controller.impl;

import com.example.dummyjson.controller.HealthCheckController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthCheckControllerImpl implements HealthCheckController {

    @Override
    public ResponseEntity<Map<String, String>> healthCheck() {
        Map<String, String> status = new HashMap<>();
        status.put("status", "UP");
        status.put("message", "Microsserviço está funcionando corretamente");
        return ResponseEntity.ok(status);
    }
}
