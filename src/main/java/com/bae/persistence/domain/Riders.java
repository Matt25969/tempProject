package com.bae.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Riders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int riderID;
	@Column(length = 50)
	private String firstName;
	@Column(length = 50)
	private String lastName;
	@Column(length = 3)
	private int riderNumber;
	@Column(length = 3)
	//@OneToOne
	private int riderTeamID;

	public Riders() {/*Empty Constructor*/}

	public Riders(int riderID, String firstName, String lastName, int riderRaceNumber, int riderTeamID) {
		this.riderID = riderID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.riderNumber = riderRaceNumber;
		this.riderTeamID = riderTeamID;
	}

	public int getRiderID() {
		return riderID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getRiderRaceNumber() {
		return riderNumber;
	}

	public int getRiderTeamID() {
		return riderTeamID;
	}

	public void setRiderID(int riderID) {
		this.riderID = riderID;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setRiderRaceNumber(int riderRaceNumber) {
		this.riderNumber = riderRaceNumber;
	}

	public void setRiderTeamID(int riderTeamID) {
		this.riderTeamID = riderTeamID;
	}
	
	
	
	
	
	
}
