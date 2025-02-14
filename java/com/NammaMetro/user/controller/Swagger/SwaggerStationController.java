package com.NammaMetro.user.controller.Swagger;

import com.NammaMetro.user.models.Station;
import com.NammaMetro.user.service.StationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Swagger/stations")
@Tag(name = "Metro Stations", description = "Endpoints for managing metro stations")
public class SwaggerStationController {
    private final StationService stationService;

    // ✅ Manually adding constructor for dependency injection
    public SwaggerStationController(StationService stationService) {
        this.stationService = stationService;
    }

    @Operation(summary = "Get all metro stations", description = "Returns a list of all metro stations")
    @GetMapping
    public ResponseEntity<List<Station>> getAllStations() {
        return ResponseEntity.ok(stationService.getAllStations());
    }
}