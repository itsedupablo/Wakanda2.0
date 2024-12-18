package com.example.wakanda.services.traffic.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TrafficLight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String interseccion;
    private String estado;
    private int duracionEstadoSegundos;
    private int flujoVehicular;
    private String nivelCongestion;

}
