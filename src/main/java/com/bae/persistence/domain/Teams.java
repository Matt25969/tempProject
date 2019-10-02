package com.bae.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teams {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teamID;
	@Column(length=50)
	private String teamName;
	@Column(length=50)
	private String motorcycleBrand;
	
	private Teams() {/*Empty Constructor*/}

	public Teams(int teamID, String teamName, String motorcycleBrand) {
		this.teamID = teamID;
		this.teamName = teamName;
		this.motorcycleBrand = motorcycleBrand;
	}

	public int getTeamID() {
		return teamID;
	}

	public String getTeamName() {
		return teamName;
	}

	public String getMotorcycleBrand() {
		return motorcycleBrand;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public void setMotorcycleBrand(String motorcycleBrand) {
		this.motorcycleBrand = motorcycleBrand;
	}
	
	
	
	
	
}
