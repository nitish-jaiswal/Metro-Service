package com.NammaMetro.user.controller;

import com.NammaMetro.user.models.Station;
import com.NammaMetro.user.service.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stations")
//@RequiredArgsConstructor
public class StationController {
    private final StationService stationService;
    public StationController(StationService stationService) {
        this.stationService = stationService;
    }


    @GetMapping
    public ResponseEntity<List<Station>> getAllStations() {
        return ResponseEntity.ok(stationService.getAllStations());
    }
}