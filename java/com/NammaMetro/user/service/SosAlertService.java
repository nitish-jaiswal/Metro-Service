package com.NammaMetro.user.service;

import com.NammaMetro.user.models.SosAlert;
import com.NammaMetro.user.models.Station;
import com.NammaMetro.user.models.User;
import com.NammaMetro.user.repository.SosAlertRepository;
import com.NammaMetro.user.repository.StationRepository;
import com.NammaMetro.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
//@RequiredArgsConstructor
public class SosAlertService {
    private final SosAlertRepository sosAlertRepository;
    private final UserRepository userRepository;
    private final StationRepository stationRepository;

    public SosAlertService(SosAlertRepository sosAlertRepository, UserRepository userRepository, StationRepository stationRepository) {
        this.sosAlertRepository = sosAlertRepository;
        this.userRepository = userRepository;
        this.stationRepository = stationRepository;
    }

    public String triggerSos(String metroCardNumber, String stationName) {
        User user = userRepository.findByMetroCardNumber(metroCardNumber)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        Station station = stationRepository.findByName(stationName)
                .orElseThrow(() -> new RuntimeException("Station not found!"));

        SosAlert alert = new SosAlert();
        alert.setUser(user);
        alert.setStation(station);
        alert.setAlertTime(LocalDateTime.now());

        sosAlertRepository.save(alert);
        return "SOS Alert triggered!";
    }
}