package com.example.wakanda.services.health.service;

import com.example.wakanda.services.health.exception.HealthMonitorNotFoundException;
import com.example.wakanda.services.health.model.HealthMonitor;
import com.example.wakanda.services.health.model.TelemedicineSession;
import com.example.wakanda.services.health.repository.HealthMonitorRepository;
import com.example.wakanda.services.health.repository.TelemedicineSessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;

@Service
public class HealthServiceImpl implements HealthService {

    private final HealthMonitorRepository healthMonitorRepository;
    private final TelemedicineSessionRepository telemedicineSessionRepository;
    private final ExecutorService executorService;

    public HealthServiceImpl(HealthMonitorRepository healthMonitorRepository, TelemedicineSessionRepository telemedicineSessionRepository, ExecutorService executorService) {
        this.healthMonitorRepository = healthMonitorRepository;
        this.telemedicineSessionRepository = telemedicineSessionRepository;
        this.executorService = executorService;
    }

    @Override
    public List<HealthMonitor> getAllHealthMonitors() {
        return healthMonitorRepository.findAll();
    }

    @Override
    public HealthMonitor getHealthMonitorById(Long id) {
        return healthMonitorRepository.findById(id)
                .orElseThrow(() -> new HealthMonitorNotFoundException("No se ha encontrado el monitor de salud con el id: " + id));
    }

    @Override
    public HealthMonitor updateHealthMonitorStatus(Long id, String status) {
        executorService.submit(() -> {
            HealthMonitor monitor = getHealthMonitorById(id);
            monitor.setEstado(status);
            healthMonitorRepository.save(monitor);
        });
        return null;
    }

    // Metodos para TelemedicineSession
    @Override
    public List<TelemedicineSession> getAllTelemedicineSessions() {
        return telemedicineSessionRepository.findAll();
    }

    @Override
    public TelemedicineSession getTelemedicineSessionById(Long id) {
        return telemedicineSessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se ha encontrado la sesión de telemedicina con el id: " + id));
        }

    @Override
    public TelemedicineSession createTelemedicineSession(TelemedicineSession telemedicineSession) {
        telemedicineSessionRepository.save(telemedicineSession);
        return telemedicineSession;
    }
}
