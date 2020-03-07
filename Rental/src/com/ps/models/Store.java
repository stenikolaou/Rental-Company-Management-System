package com.ps.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="store")
public class Store {
	
	@Id
	@Column(name="STORE_ID")
	private String storeId;
	
	@Column(name="STORE_NAME")
	private String storeName;
	
	@ManyToOne
	@JoinColumn(name="CITY_ID")
	private City city;
	
	@OneToMany (mappedBy="store", cascade = CascadeType.ALL)
	private Set<Vehicle> vehicle;
	
	public Store(String storeId, String storeName) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
	}

	public Store() {
		super();
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
	public Set<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(Set<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

}