package com.bae.business;

public interface RidersService_Interface {

	String getRiders();

	String getSingleRider(int riderID);

	String createRider(String rider);

	String deleteRider(int riderID);

	String updateRider(int riderID, String rider);

}
