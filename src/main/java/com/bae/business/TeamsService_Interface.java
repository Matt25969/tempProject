package com.bae.business;

public interface TeamsService_Interface {

	String getTeams();

	String getSingleTeam(int teamID);

	String createTeam(String team);

	String deleteTeam(int teamID);

	String updateTeam(int teamID, String team);

}
