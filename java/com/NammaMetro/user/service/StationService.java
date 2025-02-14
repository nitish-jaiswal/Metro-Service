package com.NammaMetro.user.service;

import com.NammaMetro.user.models.Station;
import com.NammaMetro.user.repository.StationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {
    private final StationRepository stationRepository;

    // ✅ Manually adding constructor
    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }
}