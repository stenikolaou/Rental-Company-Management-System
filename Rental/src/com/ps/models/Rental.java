package com.ps.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="rental")
public class Rental implements RentalDuration {
	
	@Id
	@Column(name="RENTAL_ID")
	private String rentalId;
	
	@Column(name="RENTAL_PICKUP_LOCATION")
	private String rentalPickupLocation;
	
	@Column(name="RENTAL_PICKUP_DATE")
	private static Date rentalPickupDate;
	
	@Column(name="RENTAL_RETURN_LOCATION")
	private String rentalReturnLocation;
	
	@Column(name="RENTAL_RETURN_DATE")
	private static Date rentalReturnDate;
	
	@Column(name="RENTAL_TOTAL_COST")
	private int rentalTotalCost;
	
	@ManyToOne
	@JoinColumn(name="VEHICLE_LICENCE_NO")
	private Vehicle vehicle;
	
	@ManyToOne
	@JoinColumn(name="CLIENT_ID")
	private Client client;
	
	public Rental(String rentalId, String rentalPickupLocation, Date rentalPickupDate,
			String rentalReturnLocation, Date rentalReturnDate, int rentalTotalCost) {
		this.rentalId = rentalId;
		this.rentalPickupLocation = rentalPickupLocation;
		Rental.rentalPickupDate = rentalPickupDate;
		this.rentalReturnLocation = rentalReturnLocation;
		Rental.rentalReturnDate = rentalReturnDate;
		this.rentalTotalCost = rentalTotalCost;
	}

	public String getRentalId() {
		return rentalId;
	}

	public void setRentalId(String rentalId) {
		this.rentalId = rentalId;
	}

	public String getRentalPickupLocation() {
		return rentalPickupLocation;
	}

	public void setRentalPickupLocation(String rentalPickupLocation) {
		this.rentalPickupLocation = rentalPickupLocation;
	}

	public static Date getRentalPickupDate() {
		return rentalPickupDate;
	}

	public void setRentalPickupDate(Date rentalPickupDate) {
		Rental.rentalPickupDate = rentalPickupDate;
	}

	public String getRentalReturnLocation() {
		return rentalReturnLocation;
	}

	public void setRentalReturnLocation(String rentalReturnLocation) {
		this.rentalReturnLocation = rentalReturnLocation;
	}

	public static Date getRentalReturnDate() {
		return rentalReturnDate;
	}

	public void setRentalReturnDate(Date rentalReturnDate) {
		Rental.rentalReturnDate = rentalReturnDate;
	}

	public long getRentalTotalCost() {
		long days = RentalDuration.daysBetween(one,two);
		int cost = Vehicle.getVehicleRentalCost();
		return (days*cost);
	}

	public void setRentalTotalCost(int rentalTotalCost) {
		this.rentalTotalCost = rentalTotalCost;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
}
