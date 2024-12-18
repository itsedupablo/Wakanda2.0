package com.example.wakanda.services.health.exception;

public class HealthMonitorNotFoundException extends RuntimeException {
    public HealthMonitorNotFoundException(String message) {
        super(message);
    }
}
