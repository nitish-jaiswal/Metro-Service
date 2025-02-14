package com.NammaMetro.user.repository;


import com.NammaMetro.user.models.CheckIn;

import com.NammaMetro.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface CheckInRepository extends JpaRepository<CheckIn, Long> {
    Optional<CheckIn> findByUserAndCheckInTimeIsNotNull(User user);
}