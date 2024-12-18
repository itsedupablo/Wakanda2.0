package com.example.wakanda.services.traffic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wakanda.services.traffic.model.PublicTransportRoute;

import java.util.List;
import java.util.Optional;

public interface PublicTransportRouteRepository extends JpaRepository<PublicTransportRoute, Long> {
}
