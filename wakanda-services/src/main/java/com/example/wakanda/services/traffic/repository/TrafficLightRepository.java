package com.example.wakanda.services.traffic.repository;

import com.example.wakanda.services.traffic.model.TrafficLight;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrafficLightRepository extends JpaRepository<TrafficLight, Long> {
}
