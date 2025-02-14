package com.NammaMetro.user.controller;

import com.NammaMetro.user.service.CheckOutService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/checkout")

public class CheckOutController {
    private final CheckOutService checkOutService;

    @Autowired
    public CheckOutController(CheckOutService checkOutService) {
        this.checkOutService = checkOutService;

    }


    @PostMapping
    public ResponseEntity<String> checkOut(@RequestParam String metroCard, @RequestParam String station) {
        return ResponseEntity.ok(checkOutService.checkOut(metroCard, station));
    }
}