package com.example.wakanda.services.traffic.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PublicTransportRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreRuta;
    private String estadoActual;
    private String tiempoLlegada;
    private String desviosActivos;
    private String ultimaActualizacion;
    private String siguienteParada;
    
 
}

