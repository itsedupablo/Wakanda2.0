package com.example.wakanda.services.health.utils;

import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.wakanda.services.health.model.HealthMonitor;
import com.example.wakanda.services.health.model.TelemedicineSession;
@Component
public class HealthCsvReader {

    public List<HealthMonitor> readHealthMonitorCsv(MultipartFile file) throws Exception {
        List<HealthMonitor> healthMonitors = new ArrayList<>();

        try (Reader reader = new InputStreamReader(file.getInputStream())) {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withHeader("ID", "NumeroSerie", "Estado")
                    .withIgnoreHeaderCase().withTrim());

            for (CSVRecord csvRecord : csvParser) {
                HealthMonitor healthMonitor = new HealthMonitor();

                // Settea los valores del csv a los atributos del objeto healthMonitor
                healthMonitor.setId(Long.valueOf(csvRecord.get("ID")));
                healthMonitor.setNumeroSerie(csvRecord.get("NumeroSerie"));
                healthMonitor.setEstado(csvRecord.get("Estado"));

                healthMonitors.add(healthMonitor);
            }
        }
        return healthMonitors;
    }

    public List<TelemedicineSession> readTelemedicineSessionCsv(MultipartFile file) throws Exception {
        List<TelemedicineSession> telemedicineSessions = new ArrayList<>();

        try (Reader reader = new InputStreamReader(file.getInputStream())) {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withHeader("ID", "PacienteID", "DoctorID", "FechaSesion")
                    .withIgnoreHeaderCase().withTrim());

            for (CSVRecord csvRecord : csvParser) {
                TelemedicineSession telemedicineSession = new TelemedicineSession();

                telemedicineSession.setId(Long.valueOf(csvRecord.get("ID")));
                telemedicineSession.setPatientId(Long.valueOf(csvRecord.get("PacienteID")));
                telemedicineSession.setDoctorId(Long.valueOf(csvRecord.get("DoctorID")));
                telemedicineSession.setSessionDate(LocalDateTime.parse(csvRecord.get("FechaSesion")));

                telemedicineSessions.add(telemedicineSession);
            }
        }
        return telemedicineSessions;
    }

    public List<HealthMonitor> readTrafficSensorsCsv(MultipartFile file) throws Exception {
        List<HealthMonitor> healthMonitors = new ArrayList<>();

        try (Reader reader = new InputStreamReader(file.getInputStream())) {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withHeader("ID", "Ubicacion", "VehiculosHora", "VelocidadPromedio", "AccidentesReportados", "NivelCongestion")
                    .withIgnoreHeaderCase().withTrim());

            for (CSVRecord csvRecord : csvParser) {
                HealthMonitor healthMonitor = new HealthMonitor();
                healthMonitor.setId(Long.valueOf(csvRecord.get("ID")));
                healthMonitor.setNumeroSerie(csvRecord.get("Ubicacion")); // Usando Ubicacion como ejemplo de adaptación
                healthMonitor.setEstado(csvRecord.get("NivelCongestion")); // NivelCongestion mapeado como Estado

                healthMonitors.add(healthMonitor);
            }
        }
        return healthMonitors;
    }
}