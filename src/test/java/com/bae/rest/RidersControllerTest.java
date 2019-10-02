package com.bae.rest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.business.RidersService;

@RunWith(MockitoJUnitRunner.class)
public class RidersControllerTest {

	@InjectMocks
	private RidersController repo;
	
	@Mock
	RidersService Riders;
	
	
	@Test
	public void getRidersTest() {
		Mockito.when(Riders.getRiders()).thenReturn("Success");
		Assert.assertEquals("Success", repo.getRiders());
	}
	
	@Test
	public void getSingleRiderTest() {
		Mockito.when(Riders.getSingleRider(0)).thenReturn("Success");
		Assert.assertEquals("Success", repo.getSingleRider(0));
	}
	
	@Test
	public void createRiderTest() {
		Mockito.when(Riders.createRider("rider")).thenReturn("Success");
		Assert.assertEquals("Success", repo.createRider("rider"));
	}
	
	@Test
	public void deleteRiderTest() {
		Mockito.when(Riders.deleteRider(0)).thenReturn("Success");
		Assert.assertEquals("Success", repo.deleteRider(0));
	}
	
	@Test
	public void updateRiderTest() {
		Mockito.when(Riders.updateRider(0, "rider")).thenReturn("Success");
		Assert.assertEquals("Success", repo.updateRider(0, "rider"));
	}
	
}
