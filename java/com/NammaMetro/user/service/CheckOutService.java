package com.NammaMetro.user.service;

import com.NammaMetro.user.models.CheckIn;
import com.NammaMetro.user.models.CheckOut;
import com.NammaMetro.user.models.Station;
import com.NammaMetro.user.models.User;
import com.NammaMetro.user.repository.CheckInRepository;
import com.NammaMetro.user.repository.CheckOutRepository;
import com.NammaMetro.user.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
//@RequiredArgsConstructor
public class CheckOutService {
    private final CheckOutRepository checkOutRepository;
    private final CheckInRepository checkInRepository;
    private final StationRepository stationRepository;

    public CheckOutService(CheckOutRepository checkOutRepository,
                           CheckInRepository checkInRepository,
                           StationRepository stationRepository) {
        this.checkOutRepository = checkOutRepository;
        this.checkInRepository = checkInRepository;
        this.stationRepository = stationRepository;
    }

    public String checkOut(String metroCardNumber, String stationName) {
        CheckIn checkIn = checkInRepository.findByUserAndCheckInTimeIsNotNull(
                        new User(null, metroCardNumber, null))
                .orElseThrow(() -> new RuntimeException("User not checked in!"));

        Station checkOutStation = stationRepository.findByName(stationName)
                .orElseThrow(() -> new RuntimeException("Station not found!"));

        double fare = calculateFare(checkIn.getStation(), checkOutStation);

        CheckOut checkOut = new CheckOut();
        checkOut.setCheckIn(checkIn);
        checkOut.setStation(checkOutStation);
        checkOut.setCheckOutTime(LocalDateTime.now());
        checkOut.setFare(fare);

        checkOutRepository.save(checkOut);
        return "Check-out successful! Fare: ₹" + fare;
    }

    private double calculateFare(Station start, Station end) {
        int distance = (int) (Math.abs(start.getId() - end.getId()) * 5);
        return distance;
    }
}
