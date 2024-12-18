package com.example.wakanda.services.traffic.dto;

import java.util.List;

public class TrafficDataManagerDto {

	private List<ParkingSlotDto> parkingSlots;
	private List<PublicTransportRouteDto> publicTransportRoutes;
	private List<TrafficLightDto> trafficLights;
	private List<TrafficSensorDataDto> trafficSensorData;

	// Getters y Setters
	public List<ParkingSlotDto> getParkingSlots() {
		return parkingSlots;
	}

	public void setParkingSlots(List<ParkingSlotDto> parkingSlots) {
		this.parkingSlots = parkingSlots;
	}

	public List<PublicTransportRouteDto> getPublicTransportRoutes() {
		return publicTransportRoutes;
	}

	public void setPublicTransportRoutes(List<PublicTransportRouteDto> publicTransportRoutes) {
		this.publicTransportRoutes = publicTransportRoutes;
	}

	public List<TrafficLightDto> getTrafficLights() {
		return trafficLights;
	}

	public void setTrafficLights(List<TrafficLightDto> trafficLights) {
		this.trafficLights = trafficLights;
	}

	public List<TrafficSensorDataDto> getTrafficSensorData() {
		return trafficSensorData;
	}

	public void setTrafficSensorData(List<TrafficSensorDataDto> trafficSensorData) {
		this.trafficSensorData = trafficSensorData;
	}
}
