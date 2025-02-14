package com.NammaMetro.user.controller.Swagger;

import com.NammaMetro.user.service.SosAlertService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Swagger/sos")
@Tag(name = "SOS Alert", description = "Emergency alert system")
public class SwaggerSosAlertController {
    private final SosAlertService sosAlertService;

    // ✅ Manually adding constructor for dependency injection
    public SwaggerSosAlertController(SosAlertService sosAlertService) {
        this.sosAlertService = sosAlertService;
    }

    @Operation(summary = "Trigger SOS", description = "Triggers an emergency SOS alert for a metro user")
    @PostMapping
    public ResponseEntity<String> triggerSos(@RequestParam String metroCard, @RequestParam String station) {
        return ResponseEntity.ok(sosAlertService.triggerSos(metroCard, station));
    }
}