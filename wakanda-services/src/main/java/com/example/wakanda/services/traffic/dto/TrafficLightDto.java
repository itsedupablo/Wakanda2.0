package com.example.wakanda.services.traffic.dto;

import com.example.wakanda.services.traffic.model.TrafficLight;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrafficLightDto {
    private Long id;
    private String interseccion;
    private String estado;
    private int duracionEstadoSegundos;
    private int flujoVehicular;
    private String nivelCongestion;

    public static TrafficLightDto fromModel(TrafficLight trafficLight) {
        return new TrafficLightDto(trafficLight.getId(), trafficLight.getInterseccion(), trafficLight.getEstado(), trafficLight.getDuracionEstadoSegundos(), trafficLight.getFlujoVehicular(), trafficLight.getNivelCongestion());
    }
}
