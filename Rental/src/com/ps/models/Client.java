package com.ps.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {
	
	@Id
	@Column(name="CLIENT_ID")
	private String clientId;
	
	@Column(name="CLIENT_NAME")
	private String clientName;
	
	@Column(name="CLIENT_SURNAME")
	private String clientSurname;
	
	@Column(name="CLIENT_DRIVING_LICENSE")
	private String clientDrivingLicense;
	
	@Column(name="CLIENT_ADDRESS")
	private String clientAdress;
	
	@Column(name="CLIENT_EMAIL")
	private String clientEmail;
	
	@Column(name="CLIENT_TELEPHONE_NO")
	private String clientTelephoneNo;
	
	@OneToMany (mappedBy="client", cascade = CascadeType.ALL)
	private Set<Rental> rental;
	
	public Client(String clientId, String clientName, String clientSurname, String clientDrivingLicense,
			String clientAdress, String clientEmail, String clientTelephoneNo) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientSurname = clientSurname;
		this.clientDrivingLicense = clientDrivingLicense;
		this.clientAdress = clientAdress;
		this.clientEmail = clientEmail;
		this.clientTelephoneNo = clientTelephoneNo;
	}

	public Client() {
		super();
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientSurname() {
		return clientSurname;
	}

	public void setClientSurname(String clientSurname) {
		this.clientSurname = clientSurname;
	}

	public String getClientDrivingLicense() {
		return clientDrivingLicense;
	}

	public void setClientDrivingLicense(String clientDrivingLicense) {
		this.clientDrivingLicense = clientDrivingLicense;
	}

	public String getClientAdress() {
		return clientAdress;
	}

	public void setClientAdress(String clientAdress) {
		this.clientAdress = clientAdress;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getClientTelephoneNo() {
		return clientTelephoneNo;
	}

	public void setClientTelephoneNo(String clientTelephoneNo) {
		this.clientTelephoneNo = clientTelephoneNo;
	}
	
	public Set<Rental> getRental() {
		return rental;
	}

	public void setRental(Set<Rental> rental) {
		this.rental = rental;
	}
	
}
