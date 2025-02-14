package com.NammaMetro.user.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "check_outs")
@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
public class CheckOut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "check_in_id", nullable = false)
    private CheckIn checkIn;

    @ManyToOne
    @JoinColumn(name = "station_id", nullable = false)
    private Station station;

    @Column(nullable = false)
    private LocalDateTime checkOutTime;

    @Column(nullable = false)
    private double fare;
    // Constructors
    public CheckOut() {}

    public CheckOut(CheckIn checkIn, Station station, LocalDateTime checkOutTime, double fare) {
        this.checkIn = checkIn;
        this.station = station;
        this.checkOutTime = checkOutTime;
        this.fare = fare;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public CheckIn getCheckIn() {
        return checkIn;
    }

    public Station getStation() {
        return station;
    }

    public LocalDateTime getCheckOutTime() {
        return checkOutTime;
    }

    public double getFare() {
        return fare;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setCheckIn(CheckIn checkIn) {
        this.checkIn = checkIn;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public void setCheckOutTime(LocalDateTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }
}