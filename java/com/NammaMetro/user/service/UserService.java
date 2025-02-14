package com.NammaMetro.user.service;

import com.NammaMetro.user.models.User;
import com.NammaMetro.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    // ✅ Manually adding constructor for dependency injection
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByMetroCard(String metroCardNumber) {
        return userRepository.findByMetroCardNumber(metroCardNumber)
                .orElseThrow(() -> new RuntimeException("User not found!"));
    }
}