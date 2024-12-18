package com.example.wakanda.services.health.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TelemedicineSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long doctorId;
    private Long patientId;
    private LocalDateTime sessionDate;

    public TelemedicineSession(Long doctorId, Long patientId, LocalDateTime sessionDate) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.sessionDate = sessionDate;
    }
}
