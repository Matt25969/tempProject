package com.bae.business;

import javax.inject.Inject;

import com.bae.persistence.repository.Riders_Interface;
import com.bae.util.JSONUtil;

public class RidersService implements RidersService_Interface {

	@Inject
	private JSONUtil util;

	@Inject
	Riders_Interface Riders;

	@Override
	public String getRiders() {
		return Riders.getRiders();
	}

	@Override
	public String getSingleRider(int riderID) {
		return Riders.getSingleRider(riderID);
	}

	@Override
	public String createRider(String rider) {
		return Riders.createRider(rider);
	}

	@Override
	public String deleteRider(int riderID) {
		return Riders.deleteRider(riderID);
	}

	@Override
	public String updateRider(int riderID, String rider) {
		return Riders.updateRider(riderID, rider);
	}

}
