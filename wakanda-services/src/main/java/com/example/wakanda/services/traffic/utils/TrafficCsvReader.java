package com.example.wakanda.services.traffic.utils;

import com.example.wakanda.services.traffic.model.ParkingSlot;
import com.example.wakanda.services.traffic.model.PublicTransportRoute;
import com.example.wakanda.services.traffic.model.TrafficLight;
import com.example.wakanda.services.traffic.model.TrafficSensorData;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Component
public class TrafficCsvReader {

    // Método para leer el CSV de semáforos
    public List<TrafficLight> readTrafficLightsCsv(MultipartFile file) throws Exception {
        List<TrafficLight> trafficLights = new ArrayList<>();
        
        try (Reader reader = new InputStreamReader(file.getInputStream())) {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .withHeader("ID", "Interseccion", "Estado", "DuracionEstadoSegundos", "FlujoVehicular", "NivelCongestion")
                .withIgnoreHeaderCase().withTrim());
            
            for (CSVRecord csvRecord : csvParser) {
                TrafficLight trafficLight = new TrafficLight();
                // Usamos setters tradicionales
                trafficLight.setId(Long.parseLong(csvRecord.get("ID")));
                trafficLight.setInterseccion(csvRecord.get("Interseccion"));
                trafficLight.setEstado(csvRecord.get("Estado"));
                trafficLight.setDuracionEstadoSegundos(Integer.parseInt(csvRecord.get("DuracionEstadoSegundos")));
                trafficLight.setFlujoVehicular(Integer.parseInt(csvRecord.get("FlujoVehicular")));
                trafficLight.setNivelCongestion(csvRecord.get("NivelCongestion"));
                
                trafficLights.add(trafficLight);
            }
        }
        
        return trafficLights;
    }

    // Método para leer el CSV de datos de sensores de tráfico
    public List<TrafficSensorData> readTrafficSensorDataCsv(MultipartFile file) throws Exception {
        List<TrafficSensorData> sensorDataList = new ArrayList<>();
        
        try (Reader reader = new InputStreamReader(file.getInputStream())) {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .withHeader("ID", "Ubicacion", "VehiculosHora", "VelocidadPromedio", "AccidentesReportados", "NivelCongestion")
                .withIgnoreHeaderCase().withTrim());
            
            for (CSVRecord csvRecord : csvParser) {
                TrafficSensorData sensorData = new TrafficSensorData();
                // Usamos setters tradicionales
                sensorData.setId(Long.parseLong(csvRecord.get("ID")));
                sensorData.setUbicacion(csvRecord.get("Ubicacion"));
                sensorData.setVehiculosHora(Integer.parseInt(csvRecord.get("VehiculosHora")));
                sensorData.setVelocidadPromedio(Double.parseDouble(csvRecord.get("VelocidadPromedio")));
                sensorData.setAccidentesReportados(Integer.parseInt(csvRecord.get("AccidentesReportados")));
                sensorData.setNivelCongestion(csvRecord.get("NivelCongestion"));
                
                sensorDataList.add(sensorData);
            }
        }
        
        return sensorDataList;
    }

    // Método para leer el CSV de plazas de aparcamiento
    public List<ParkingSlot> readParkingSlotsCsv(MultipartFile file) throws Exception {
        List<ParkingSlot> parkingSlots = new ArrayList<>();
        
        try (Reader reader = new InputStreamReader(file.getInputStream())) {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .withHeader("ID", "UbicacionPlaza", "Estado")
                .withIgnoreHeaderCase().withTrim());
            
            for (CSVRecord csvRecord : csvParser) {
                ParkingSlot parkingSlot = new ParkingSlot();
                // Usamos setters tradicionales
                parkingSlot.setId(Long.parseLong(csvRecord.get("ID")));
                parkingSlot.setUbicacionPlaza(csvRecord.get("UbicacionPlaza"));
                parkingSlot.setEstado(csvRecord.get("Estado"));
                
                parkingSlots.add(parkingSlot);
            }
        }
        
        return parkingSlots;
    }

    // Método para leer el CSV de rutas de transporte público
    public List<PublicTransportRoute> readPublicTransportRoutesCsv(MultipartFile file) throws Exception {
        List<PublicTransportRoute> routes = new ArrayList<>();
        
        try (Reader reader = new InputStreamReader(file.getInputStream())) {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .withHeader("ID", "Nombre_Ruta", "Estado_Actual", "Tiempo_Llegada", "Desvios_Activos", "Ultima_Actualizacion", "Siguiente_Parada")
                .withIgnoreHeaderCase().withTrim());
            
            for (CSVRecord csvRecord : csvParser) {
                PublicTransportRoute route = new PublicTransportRoute();
                // Usamos setters tradicionales
                route.setId(Long.parseLong(csvRecord.get("ID")));
                route.setNombreRuta(csvRecord.get("Nombre_Ruta"));
                route.setEstadoActual(csvRecord.get("Estado_Actual"));
                route.setTiempoLlegada(csvRecord.get("Tiempo_Llegada"));
                route.setDesviosActivos(csvRecord.get("Desvios_Activos"));
                route.setUltimaActualizacion(csvRecord.get("Ultima_Actualizacion"));
                route.setSiguienteParada(csvRecord.get("Siguiente_Parada"));
                
                routes.add(route);
            }
        }
        
        return routes;
    }
}
