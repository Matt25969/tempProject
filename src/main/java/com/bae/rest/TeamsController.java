package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.bae.business.TeamsService;

@Path("/Teams")
public class TeamsController {

	@Inject
	TeamsService Teams;

	@Path("/GetTeams")
	@GET
	public String getTeams() {
		return Teams.getTeams();
	}

	@Path("/GetSingleTeam/{teamID}")
	@GET
	public String getSingleTeam(@PathParam("teamID") int teamID) {
		return Teams.getSingleTeam(teamID);
	}

	@Path("/CreateTeam")
	@POST
	public String createTeam(String team) {
		return Teams.createTeam(team);

	}

	@Path("/DeleteTeam/{teamID}")
	@DELETE
	public String deleteTeam(@PathParam("teamID") int teamID) {
		return Teams.deleteTeam(teamID);
	}

	@Path("/UpdateTeam/{teamID}")
	@PUT
	public String updateTeam(@PathParam("teamID") int teamID, String team) {
		return Teams.updateTeam(teamID, team);
	}

}
