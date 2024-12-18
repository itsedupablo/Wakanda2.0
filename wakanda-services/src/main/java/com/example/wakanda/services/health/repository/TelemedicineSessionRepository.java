package com.example.wakanda.services.health.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.wakanda.services.health.model.TelemedicineSession;

import java.time.LocalDateTime;
import java.util.List;

public interface TelemedicineSessionRepository extends JpaRepository<TelemedicineSession, Long> {
    List<TelemedicineSession> findByDoctorId(Long doctorId);
    List<TelemedicineSession> findByPatientIdAndSessionDateBetween(Long patientId, LocalDateTime start, LocalDateTime end);
}
