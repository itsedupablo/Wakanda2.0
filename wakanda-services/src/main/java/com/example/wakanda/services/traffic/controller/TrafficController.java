package com.example.wakanda.services.traffic.controller;

import com.example.wakanda.services.traffic.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.wakanda.services.traffic.service.TrafficService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/traffic")
public class TrafficController {

    private final TrafficService trafficService;

    public TrafficController(TrafficService trafficService) {
        this.trafficService = trafficService;
    }

    // Endpoint para obtener todos los datos de tráfico
    @GetMapping("/all")
    public ResponseEntity<TrafficDataManagerDto> getAllTrafficData() {
        // Se obtienen los datos de los diferentes tipos a través del servicio unificado
        List<ParkingSlotDto> parkingSlots = trafficService.getAllParkingSlots().stream()
                .map(ParkingSlotDto::fromModel)
                .collect(Collectors.toList());
        List<PublicTransportRouteDto> publicTransportRoutes = trafficService.getAllPublicTransportRoutes().stream()
                .map(PublicTransportRouteDto::fromModel)
                .collect(Collectors.toList());
        List<TrafficLightDto> trafficLights = trafficService.getAllTrafficLights().stream()
                .map(TrafficLightDto::fromModel)
                .collect(Collectors.toList());
        List<TrafficSensorDataDto> trafficSensorData = trafficService.getAllSensorData().stream()
                .map(TrafficSensorDataDto::fromModel)
                .collect(Collectors.toList());

        // Envolvemos los datos en un DTO genérico para la respuesta
        TrafficDataManagerDto response = new TrafficDataManagerDto();
        response.setParkingSlots(parkingSlots);
        response.setPublicTransportRoutes(publicTransportRoutes);
        response.setTrafficLights(trafficLights);
        response.setTrafficSensorData(trafficSensorData);

        return ResponseEntity.ok(response);
    }

    // Endpoint para procesar los archivos CSV
    @PostMapping("/process-csv")
    public ResponseEntity<String> processCsvData(@RequestParam("file") MultipartFile file) {
        // Validación: verificar si el archivo está vacío
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("El archivo CSV está vacío. Por favor, suba un archivo válido.");
        }
    
        try {
            // Se procesa el archivo CSV
            trafficService.processCsv(file, "trafficLights");
        } catch (Exception e) {
            // Se podría agregar un log aquí para mayor trazabilidad
            return ResponseEntity.badRequest().body("Error procesando los datos del CSV: " + e.getMessage());
        }
        return ResponseEntity.ok("Datos del archivo CSV '" + file.getOriginalFilename() + "' procesados con éxito!");
    }
}
