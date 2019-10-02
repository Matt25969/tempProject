package com.bae.persistence.repository;

public interface Teams_Interface {

	String getTeams();
	String getSingleTeam(int teamID);
	String createTeam(String team);
	String deleteTeam(int teamID);
	String updateTeam(int teamID, String team);
	
	
}
