package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.bae.business.RaceLogService;

@Path("/RaceLog") 
public class RaceLogController {

	@Inject
	RaceLogService Racelog;

	@Path("/GetRaceLog")
	@GET
	public String getRaceLog() {
		return Racelog.getRaceLog();
	}

	@Path("/GetRaceLogEntry/{entryID}")
	@GET
	public String getRaceLogEntry(@PathParam("entryID") int entryID) {
		return Racelog.getRaceLogEntry(entryID);
	}

	@Path("/CreateRaceLogEntry")
	@POST
	public String createRaceLogEntry(String raceLogEntry) {
		return Racelog.createRaceLogEntry(raceLogEntry);
	}

	@Path("/DeleteRaceLogEntry/{entryID}")
	@DELETE
	public String deleteRaceLogEntry(@PathParam("entryID") int entryID) {
		return Racelog.deleteRaceLogEntry(entryID);
	}

	@Path("/UpdateRaceLogEntry/{entryID}")
	@PUT
	public String updateRaceLogEntry(@PathParam("entryID") int entryID, String raceLogEntry) {
		return Racelog.updateRaceLogEntry(entryID, raceLogEntry);
	}

}
