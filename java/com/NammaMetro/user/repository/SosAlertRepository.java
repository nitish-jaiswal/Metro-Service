package com.NammaMetro.user.repository;

import com.NammaMetro.user.models.SosAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SosAlertRepository extends JpaRepository<SosAlert, Long> {
}