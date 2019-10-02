package com.bae.business;

import javax.inject.Inject;

import com.bae.persistence.repository.Teams_Interface;
import com.bae.util.JSONUtil;

public class TeamsService implements TeamsService_Interface {

	@Inject
	private JSONUtil util;

	@Inject
	Teams_Interface Teams;

	@Override
	public String getTeams() {
		return Teams.getTeams();
	}

	@Override
	public String getSingleTeam(int teamID) {
		return Teams.getSingleTeam(teamID);
	}

	@Override
	public String createTeam(String team) {
		return Teams.createTeam(team);
	}

	@Override
	public String deleteTeam(int teamID) {
		return Teams.deleteTeam(teamID);
	}

	@Override
	public String updateTeam(int teamID, String team) {
		return Teams.updateTeam(teamID, team);
	}

}
