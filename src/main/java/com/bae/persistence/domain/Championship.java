package com.bae.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Championship {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int championshipPosition;
	@Column(length = 3)
	private int riderTotalPoints;
	@Column(length = 2)
	private int riderID;
	@Column(length = 2)
	private int teamID;

	public Championship() {
		/* Empty Constructor */}

	public Championship(int championshipPosition, int riderTotalPoints, int riderID, int teamID) {
		this.championshipPosition = championshipPosition;
		this.riderTotalPoints = riderTotalPoints;
		this.riderID = riderID;
		this.teamID = teamID;
	}

	public int getChampionshipPosition() {
		return championshipPosition;
	}

	public int getRiderTotalPoints() {
		return riderTotalPoints;
	}

	public int getRiderID() {
		return riderID;
	}

	public int getTeamID() {
		return teamID;
	}

	public void setChampionshipPosition(int championshipPosition) {
		this.championshipPosition = championshipPosition;
	}

	public void setRiderTotalPoints(int riderTotalPoints) {
		this.riderTotalPoints = riderTotalPoints;
	}

	public void setRiderID(int riderID) {
		this.riderID = riderID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}

}
