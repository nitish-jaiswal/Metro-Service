package com.NammaMetro.user.service;

import com.NammaMetro.user.models.CheckIn;
import com.NammaMetro.user.models.Station;
import com.NammaMetro.user.models.User;
import com.NammaMetro.user.repository.CheckInRepository;
import com.NammaMetro.user.repository.StationRepository;
import com.NammaMetro.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service

public class CheckInService {
    private final CheckInRepository checkInRepository;
    private final UserRepository userRepository;
    private final StationRepository stationRepository;

    @Autowired
    public CheckInService(CheckInRepository checkInRepository,
                          UserRepository userRepository,
                          StationRepository stationRepository) {
        this.checkInRepository = checkInRepository;
        this.userRepository = userRepository;
        this.stationRepository = stationRepository;
    }

    public String checkIn(String metroCardNumber, String stationName) {
        User user = userRepository.findByMetroCardNumber(metroCardNumber)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        Station station = stationRepository.findByName(stationName)
                .orElseThrow(() -> new RuntimeException("Station not found!"));



        CheckIn checkIn = new CheckIn();
        checkIn.setUser(user);
        checkIn.setStation(station);
        checkIn.setCheckInTime(LocalDateTime.now());

        checkInRepository.save(checkIn);
        return "Check-in successful!";
    }
}