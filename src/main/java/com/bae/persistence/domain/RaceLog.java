package com.bae.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RaceLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int entryID;
	@Column(length = 2)
	private int raceNumber;
	@Column(length = 50)
	private String raceLocation;
	@Column(length = 2)
	private int riderID;
	@Column(length = 2)
	private int teamID;
	@Column(length = 2)
	private int racePosition;
	@Column(length = 2)
	private int racePoints;

	public RaceLog() {
		/* Empty Constructor */}

	public RaceLog(int entryID, int raceNumber, String raceLocation, int riderID, int teamID, int racePosition,
			int racePoints) {
		this.entryID = entryID;
		this.raceNumber = raceNumber;
		this.raceLocation = raceLocation;
		this.riderID = riderID;
		this.teamID = teamID;
		this.racePosition = racePosition;
		this.racePoints = racePoints;
	}

	public int getEntryID() {
		return entryID;
	}

	public int getRaceNumber() {
		return raceNumber;
	}

	public String getRaceLocation() {
		return raceLocation;
	}

	public int getRiderID() {
		return riderID;
	}

	public int getTeamID() {
		return teamID;
	}

	public int getRacePosition() {
		return racePosition;
	}

	public int getRacePoints() {
		return racePoints;
	}

	public void setEntryID(int entryID) {
		this.entryID = entryID;
	}

	public void setRaceNumber(int raceNumber) {
		this.raceNumber = raceNumber;
	}

	public void setRaceLocation(String raceLocation) {
		this.raceLocation = raceLocation;
	}

	public void setRiderID(int riderID) {
		this.riderID = riderID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}

	public void setRacePoints(int racePoints) {
		this.racePoints = racePoints;
	}

	public void setRacePosition(int racePosition) {
		this.racePosition = racePosition;
	}

}
