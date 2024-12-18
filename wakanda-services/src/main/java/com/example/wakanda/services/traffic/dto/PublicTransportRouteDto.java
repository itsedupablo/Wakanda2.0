package com.example.wakanda.services.traffic.dto;


import com.example.wakanda.services.traffic.model.PublicTransportRoute;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicTransportRouteDto {
    private Long id;
    private String nombreRuta;
    private String estadoActual;
    private String tiempoLlegada;
    private String desviosActivos;
    private String ultimaActualizacion;
    private String siguienteParada;

    public static PublicTransportRouteDto fromModel(PublicTransportRoute publicTransportRoute) {
        return new PublicTransportRouteDto(publicTransportRoute.getId(), publicTransportRoute.getNombreRuta(), publicTransportRoute.getEstadoActual(), publicTransportRoute.getTiempoLlegada(), publicTransportRoute.getDesviosActivos(), publicTransportRoute.getUltimaActualizacion(), publicTransportRoute.getSiguienteParada());
    }

}
