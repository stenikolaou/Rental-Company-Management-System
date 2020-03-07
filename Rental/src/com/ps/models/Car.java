package com.ps.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Car")
public class Car extends Vehicle {
	

	public Car(String vehicleLicenceNo, String vehicleModel, String vehicleFuel, String vehicleCapacity,
			int vehicleRentalCost, String vehicleType, int vehicleSeatNo, int vehicleDoorNumber) {
		super(vehicleLicenceNo, vehicleModel, vehicleFuel, vehicleCapacity, vehicleRentalCost, vehicleType);
		this.vehicleSeatNo = vehicleSeatNo;
		this.vehicleDoorNumber = vehicleDoorNumber;
	}

	@Column(name="VEHICLE_SEAT_NO")
	private int vehicleSeatNo;
	
	@Column(name="VEHICLE_DOOR_NUMBER")
	private int vehicleDoorNumber;
	
	public int getVehicleSeatNo() {
		return vehicleSeatNo;
	}

	public void setVehicleSeatNo(int vehicleSeatNo) {
		this.vehicleSeatNo = vehicleSeatNo;
	}

	public int getVehicleDoorNumber() {
		return vehicleDoorNumber;
	}

	public void setVehicleDoorNumber(int vehicleDoorNumber) {
		this.vehicleDoorNumber = vehicleDoorNumber;
	}
	
}
