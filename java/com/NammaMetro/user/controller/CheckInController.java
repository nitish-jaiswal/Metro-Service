package com.NammaMetro.user.controller;

import com.NammaMetro.user.service.CheckInService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/checkin")
public class CheckInController {
    private final CheckInService checkInService;

    // ✅ Use Constructor Injection here
    @Autowired
    public CheckInController(CheckInService checkInService) {
        this.checkInService = checkInService;
    }

    @PostMapping
    public ResponseEntity<String> checkIn(@RequestParam String metroCard, @RequestParam String station) {
        return ResponseEntity.ok(checkInService.checkIn(metroCard, station));
    }
}




