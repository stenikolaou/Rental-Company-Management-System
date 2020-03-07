package com.ps.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="vehicle")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="GeneralType", discriminatorType=DiscriminatorType.STRING)
public abstract class Vehicle {
	
	@SuppressWarnings("static-access")
	public Vehicle(String vehicleLicenceNo, String vehicleModel, String vehicleFuel, String vehicleCapacity,
			int vehicleRentalCost, String vehicleType) {
		super();
		this.vehicleLicenceNo = vehicleLicenceNo;
		this.vehicleModel = vehicleModel;
		this.vehicleFuel = vehicleFuel;
		this.vehicleCapacity = vehicleCapacity;
		this.vehicleRentalCost = vehicleRentalCost;
		this.vehicleType = vehicleType;
	}
	@Id
	@Column(name="VEHICLE_LICENCE_NO")
	private String vehicleLicenceNo;
	
	@Column(name="VEHICLE_MODEL")
	private String vehicleModel;
	
	@Column(name="VEHICLE_FUEL")
	private String vehicleFuel;
	
	@Column(name="VEHICLE_CAPACITY")
	private String vehicleCapacity;
		
	@Column(name="VEHICLE_RENTAL_COST")
	private static int vehicleRentalCost;
	
	@Column(name="VEHICLE_TYPE")
	private String vehicleType; 

	@ManyToOne
	@JoinColumn(name="STORE_ID")
	private Store store;
	
	@OneToMany (mappedBy="vehicle", cascade = CascadeType.ALL)
	private Set<Rental> rental;
		
	public String getVehicleLicenceNo() {
		return vehicleLicenceNo;
	}

	public void setVehicleLicenceNo(String vehicleLicenceNo) {
		this.vehicleLicenceNo = vehicleLicenceNo;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleFuel() {
		return vehicleFuel;
	}

	public void setVehicleFuel(String vehicleFuel) {
		this.vehicleFuel = vehicleFuel;
	}

	public String getVehicleCapacity() {
		return vehicleCapacity;
	}

	public void setVehicleCapacity(String vehicleCapacity) {
		this.vehicleCapacity = vehicleCapacity;
	}

	public static int getVehicleRentalCost() {
		return vehicleRentalCost;
	}

	@SuppressWarnings("static-access")
	public void setVehicleRentalCost(int vehicleRentalCost) {
		this.vehicleRentalCost = vehicleRentalCost;
	}
	
	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	
	public Set<Rental> getRental() {
		return rental;
	}

	public void setRental(Set<Rental> rental) {
		this.rental = rental;
	}
		
}
