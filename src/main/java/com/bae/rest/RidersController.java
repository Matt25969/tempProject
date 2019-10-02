package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.bae.business.RidersService;

@Path("/Riders")
public class RidersController {

	@Inject
	RidersService Riders;

	@Path("/GetRiders")
	@GET
	public String getRiders() {

		return Riders.getRiders();

	}

	@Path("/GetSingleRider/{riderID}")
	@GET
	public String getSingleRider(@PathParam("riderID") int riderID) {
		return Riders.getSingleRider(riderID);
	}

	@Path("/CreateRider")
	@POST
	public String createRider(String rider) {
		return Riders.createRider(rider);

	}

	@Path("/DeleteRider/{riderID}")
	@DELETE
	public String deleteRider(@PathParam("riderID") int riderID) {
		return Riders.deleteRider(riderID);
	}

	@Path("/UpdateRider/{riderID}")
	@PUT
	public String updateRider(@PathParam("riderID") int riderID, String rider) {
		return Riders.updateRider(riderID, rider);
	}

}
