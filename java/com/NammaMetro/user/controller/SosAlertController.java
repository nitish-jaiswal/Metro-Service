package com.NammaMetro.user.controller;

import com.NammaMetro.user.service.SosAlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sos")
//@RequiredArgsConstructor
public class SosAlertController {
    private final SosAlertService sosAlertService;

    public SosAlertController(SosAlertService sosAlertService) {
        this.sosAlertService = sosAlertService;
    }

    @PostMapping
    public ResponseEntity<String> triggerSos(@RequestParam String metroCard, @RequestParam String station) {
        return ResponseEntity.ok(sosAlertService.triggerSos(metroCard, station));
    }
}