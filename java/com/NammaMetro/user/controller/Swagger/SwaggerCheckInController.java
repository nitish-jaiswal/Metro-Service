package com.NammaMetro.user.controller.Swagger;

import com.NammaMetro.user.service.CheckInService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Swagger/checkin")
@Tag(name = "Check-in", description = "Endpoints for metro check-in")
public class SwaggerCheckInController {
    private final CheckInService checkInService;

    // ✅ Manually adding constructor for dependency injection
    public SwaggerCheckInController(CheckInService checkInService) {
        this.checkInService = checkInService;
    }

    @Operation(summary = "User Check-in", description = "Allows users to check in to a metro station")
    @PostMapping
    public ResponseEntity<String> checkIn(@RequestParam String metroCard, @RequestParam String station) {
        return ResponseEntity.ok(checkInService.checkIn(metroCard, station));
    }
}