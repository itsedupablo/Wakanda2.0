package com.example.wakanda.services.health.controller;

import com.example.wakanda.services.health.model.HealthMonitor;
import com.example.wakanda.services.health.model.TelemedicineSession;
import com.example.wakanda.services.health.service.HealthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/health")
public class HealthController {

    private final HealthService healthService;

    public HealthController(HealthService healthService) {
        this.healthService = healthService;
    }

    // Endpoint para obtener todos los datos de salud
    @RequestMapping("/monitors")
    public ResponseEntity<List<HealthMonitor>> getAllHealthMonitors() {
        return ResponseEntity.ok(healthService.getAllHealthMonitors());
    }

    @GetMapping("/monitors/{id}")
    public ResponseEntity<HealthMonitor> getHealthMonitorById(@PathVariable Long id) {
        HealthMonitor monitor = healthService.getHealthMonitorById(id);
        return ResponseEntity.ok(monitor);
    }

    @PatchMapping("/monitors/{id}/status")
    public ResponseEntity<HealthMonitor> updateHealthMonitorStatus(@PathVariable Long id, @RequestParam("status") String status) {
        healthService.updateHealthMonitorStatus(id, status);
        return ResponseEntity.ok().build();
    }

    // Endpoints para TelemedicineSession

    @GetMapping("/sessions")
    public ResponseEntity<List<TelemedicineSession>> getAllTelemedicineSessions() {
        return ResponseEntity.ok(healthService.getAllTelemedicineSessions());
    }

    @GetMapping("/sessions/{id}")
    public ResponseEntity<TelemedicineSession> getTelemedicineSessionById(@PathVariable Long id) {
        TelemedicineSession session = healthService.getTelemedicineSessionById(id);
        return ResponseEntity.ok(session);
    }

    @PostMapping("/sessions")
    public ResponseEntity<TelemedicineSession> createTelemedicineSession(@RequestBody TelemedicineSession session) {
        TelemedicineSession createdSession = healthService.createTelemedicineSession(session);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSession);
    }
}


