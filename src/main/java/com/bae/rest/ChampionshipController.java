package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.bae.business.ChampionshipService;

@Path("/Championship")
public class ChampionshipController {

@Inject
ChampionshipService Championship;

@Path("/GetChampionship")
@GET
public String getChampionship() {
	return Championship.getChampionship();
}
	
}
