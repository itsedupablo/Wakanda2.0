package com.example.wakanda.services.traffic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wakanda.services.traffic.model.TrafficSensorData;

import java.util.List;
import java.util.Optional;

public interface TrafficSensorDataRepository extends JpaRepository<TrafficSensorData, Long> {

}
