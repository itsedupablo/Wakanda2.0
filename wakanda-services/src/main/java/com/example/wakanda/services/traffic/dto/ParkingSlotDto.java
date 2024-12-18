package com.example.wakanda.services.traffic.dto;

import com.example.wakanda.services.traffic.model.ParkingSlot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSlotDto {
    private Long id;
    private String ubicacionPlaza;
    private String estado;

    public static ParkingSlotDto fromModel(ParkingSlot parkingSlot) {
        return new ParkingSlotDto(parkingSlot.getId(), parkingSlot.getUbicacionPlaza(), parkingSlot.getEstado());
    }
}
