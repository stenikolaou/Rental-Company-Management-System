package com.ps.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TwoWheeled")
public class TwoWheeled extends Vehicle {
	
	public TwoWheeled(String vehicleLicenceNo, String vehicleModel, String vehicleFuel, String vehicleCapacity,
			int vehicleRentalCost, String vehicleType, int vehicleSeatHeight, String vehicleLuggageSupport) {
		super(vehicleLicenceNo, vehicleModel, vehicleFuel, vehicleCapacity, vehicleRentalCost, vehicleType);
		this.vehicleSeatHeight = vehicleSeatHeight;
		this.vehicleLuggageSupport = vehicleLuggageSupport;
	}

	@Column(name="VEHICLE_SEAT_HEIGHT")
	private int vehicleSeatHeight; 
	
	@Column(name="VEHICLE_LUGGAGE_SUPPORT")
	private String vehicleLuggageSupport;
	
	public int getVehicleSeatHeight() {
		return vehicleSeatHeight;
	}

	public void setVehicleSeatHeight(int vehicleSeatHeight) {
		this.vehicleSeatHeight = vehicleSeatHeight;
	}

	public String getVehicleLuggageSupport() {
		return vehicleLuggageSupport;
	}

	public void setVehicleLuggageSupport(String vehicleLuggageSupport) {
		this.vehicleLuggageSupport = vehicleLuggageSupport;
	}
	
}
