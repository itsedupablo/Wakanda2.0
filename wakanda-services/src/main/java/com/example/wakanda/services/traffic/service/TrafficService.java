package com.example.wakanda.services.traffic.service;

import com.example.wakanda.services.traffic.model.ParkingSlot;
import com.example.wakanda.services.traffic.model.PublicTransportRoute;
import com.example.wakanda.services.traffic.model.TrafficLight;
import com.example.wakanda.services.traffic.model.TrafficSensorData;
import com.example.wakanda.services.traffic.repository.ParkingSlotRepository;
import com.example.wakanda.services.traffic.repository.PublicTransportRouteRepository;
import com.example.wakanda.services.traffic.repository.TrafficLightRepository;
import com.example.wakanda.services.traffic.repository.TrafficSensorDataRepository;
import com.example.wakanda.services.traffic.utils.TrafficCsvReader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class TrafficService {

    private final TrafficCsvReader csvReader;
    private final ParkingSlotRepository parkingSlotRepository;
    private final PublicTransportRouteRepository publicTransportRouteRepository;
    private final TrafficLightRepository trafficLightRepository;
    private final TrafficSensorDataRepository trafficSensorDataRepository;

    public TrafficService(TrafficCsvReader csvReader,
                          ParkingSlotRepository parkingSlotRepository,
                          PublicTransportRouteRepository publicTransportRouteRepository,
                          TrafficLightRepository trafficLightRepository,
                          TrafficSensorDataRepository trafficSensorDataRepository) {
        this.csvReader = csvReader;
        this.parkingSlotRepository = parkingSlotRepository;
        this.publicTransportRouteRepository = publicTransportRouteRepository;
        this.trafficLightRepository = trafficLightRepository;
        this.trafficSensorDataRepository = trafficSensorDataRepository;
    }

    // Métodos para gestionar Parking Slots
    public List<ParkingSlot> getAllParkingSlots() {
        return parkingSlotRepository.findAll();
    }

    public void saveParkingSlots(List<ParkingSlot> parkingSlots) {
        parkingSlotRepository.saveAll(parkingSlots);
    }

    // Métodos para gestionar Public Transport Routes
    public List<PublicTransportRoute> getAllPublicTransportRoutes() {
        return publicTransportRouteRepository.findAll();
    }

    public void savePublicTransportRoutes(List<PublicTransportRoute> routes) {
        publicTransportRouteRepository.saveAll(routes);
    }

    // Métodos para gestionar Traffic Lights
    public List<TrafficLight> getAllTrafficLights() {
        return trafficLightRepository.findAll();
    }

    public List<TrafficLight> saveTrafficLights(List<TrafficLight> trafficLights) {
        trafficLightRepository.saveAll(trafficLights);
        return trafficLights;
    }

    // Métodos para gestionar Traffic Sensor Data
    public List<TrafficSensorData> getAllSensorData() {
        return trafficSensorDataRepository.findAll();
    }

    public void saveSensorData(List<TrafficSensorData> sensorData) {
        trafficSensorDataRepository.saveAll(sensorData);
    }

    // Método para procesar el CSV según el tipo de dato
    public void processCsv(MultipartFile file, String type) throws Exception {
        switch (type) {
            case "trafficLights":
                List<TrafficLight> trafficLights = csvReader.readTrafficLightsCsv(file);
                saveTrafficLights(trafficLights);
                break;
            case "sensorData":
                List<TrafficSensorData> sensorData = csvReader.readTrafficSensorDataCsv(file);
                saveSensorData(sensorData);
                break;
            case "parkingSlots":
                List<ParkingSlot> parkingSlots = csvReader.readParkingSlotsCsv(file);
                saveParkingSlots(parkingSlots);
                break;
            case "publicTransportRoutes":
                List<PublicTransportRoute> routes = csvReader.readPublicTransportRoutesCsv(file);
                savePublicTransportRoutes(routes);
                break;
            default:
                throw new IllegalArgumentException("Tipo de CSV no soportado: " + type);
        }
    }
}
