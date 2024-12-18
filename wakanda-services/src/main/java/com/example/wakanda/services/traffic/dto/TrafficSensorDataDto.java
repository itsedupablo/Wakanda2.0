package com.example.wakanda.services.traffic.dto;

import com.example.wakanda.services.traffic.model.TrafficSensorData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrafficSensorDataDto {
    private Long id;
    private String ubicacion;
    private int vehiculosHora;
    private double velocidadPromedio;
    private int accidentesReportados;
    private String nivelCongestion;

    public static TrafficSensorDataDto fromModel(TrafficSensorData trafficSensorData) {
        return new TrafficSensorDataDto(trafficSensorData.getId(), trafficSensorData.getUbicacion(), trafficSensorData.getVehiculosHora(), trafficSensorData.getVelocidadPromedio(), trafficSensorData.getAccidentesReportados(), trafficSensorData.getNivelCongestion());
    }
}