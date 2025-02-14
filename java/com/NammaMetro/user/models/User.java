package com.NammaMetro.user.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;




    @Column(nullable = false, unique = true)
    private String metroCardNumber;

    @Column(nullable = false)
    private String name;

    // Constructors
    public User() {}

    public User(Long id, String metroCardNumber, String name) {
        this.id = id;
        this.metroCardNumber = metroCardNumber;
        this.name = name;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getMetroCardNumber() {
        return metroCardNumber;
    }

    public String getName() {
        return name;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setMetroCardNumber(String metroCardNumber) {
        this.metroCardNumber = metroCardNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

}