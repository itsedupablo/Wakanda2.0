package com.example.wakanda.services.health.service;

import com.example.wakanda.services.health.model.HealthMonitor;
import com.example.wakanda.services.health.model.TelemedicineSession;

import java.util.List;

public interface HealthService {
    List<HealthMonitor> getAllHealthMonitors();
    HealthMonitor getHealthMonitorById(Long id);
    HealthMonitor updateHealthMonitorStatus(Long id, String status);

    // Metodos para TelemedicineSession
    List<TelemedicineSession> getAllTelemedicineSessions();
    TelemedicineSession getTelemedicineSessionById(Long id);
    TelemedicineSession createTelemedicineSession(TelemedicineSession telemedicineSession);
}
