package com.example.wakanda.services.health.dto;

import com.example.wakanda.services.health.model.HealthMonitor;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HealthMonitorDto {
    private Long id;
    private String numeroSerie;
    private String estado;

    public static HealthMonitorDto fromModel(HealthMonitor healthMonitor) {
        return new HealthMonitorDto(healthMonitor.getId(), healthMonitor.getNumeroSerie(), healthMonitor.getEstado());
    }
}
