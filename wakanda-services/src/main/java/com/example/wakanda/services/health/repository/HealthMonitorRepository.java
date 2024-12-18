package com.example.wakanda.services.health.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.wakanda.services.health.model.HealthMonitor;

import java.util.List;
import java.util.Optional;

public interface HealthMonitorRepository extends JpaRepository<HealthMonitor, Long> {
}
