package com.NammaMetro.user.controller.Swagger;

import com.NammaMetro.user.service.CheckOutService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Swagger/checkout")
@Tag(name = "Check-out", description = "Endpoints for metro check-out")
public class SwaggerCheckOutController {
    private final CheckOutService checkOutService;

    // ✅ Manually adding constructor for dependency injection
    public SwaggerCheckOutController(CheckOutService checkOutService) {
        this.checkOutService = checkOutService;
    }

    @Operation(summary = "User Check-out", description = "Allows users to check out and calculates fare")
    @PostMapping
    public ResponseEntity<String> checkOut(@RequestParam String metroCard, @RequestParam String station) {
        return ResponseEntity.ok(checkOutService.checkOut(metroCard, station));
    }
}