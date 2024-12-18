package com.example.wakanda.services.traffic.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ParkingSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ubicacionPlaza;
    private String estado; 
    
	
	
}
