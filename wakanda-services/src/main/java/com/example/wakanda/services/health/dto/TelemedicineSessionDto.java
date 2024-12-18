package com.example.wakanda.services.health.dto;

import com.example.wakanda.services.health.model.TelemedicineSession;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TelemedicineSessionDto {
    private Long id;
    private Long doctorId;
    private Long patientId;
    private String sessionDate;

    public static TelemedicineSessionDto fromModel(TelemedicineSession telemedicineSession) {
        return new TelemedicineSessionDto(telemedicineSession.getId(), telemedicineSession.getDoctorId(), telemedicineSession.getPatientId(), telemedicineSession.getSessionDate().toString());
    }
}
