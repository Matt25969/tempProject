package com.bae.business;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.persistence.repository.Riders_Interface;

@RunWith(MockitoJUnitRunner.class)
public class RidersServiceTest {

	@InjectMocks
	private RidersService repo;
	
	@Mock
	Riders_Interface Riders;
	
	private static final String MOCK_OBJECT = "{\"riderID\":1,\"firstName\":\"Jack\",\"lastName\":\"jackson\",\"riderNumber\":55,\"riderTeamID\":2}";

	@Test
	public void getRidersTest() {
		Mockito.when(Riders.getRiders()).thenReturn(MOCK_OBJECT);
		Assert.assertEquals(MOCK_OBJECT, repo.getRiders());
	}
	
	@Test
	public void getSingleRiderTest() {
		Mockito.when(Riders.getSingleRider(1)).thenReturn(MOCK_OBJECT);
		Assert.assertEquals(MOCK_OBJECT, repo.getSingleRider(1));
	} 
	
	@Test
	public void createRiderTest() {
		Mockito.when(Riders.createRider(MOCK_OBJECT)).thenReturn("Rider Created");
		Assert.assertEquals("Rider Created", repo.createRider(MOCK_OBJECT));
	} 
	
	@Test
	public void deleteRiderTest() {
		Mockito.when(Riders.deleteRider(1)).thenReturn("Rider Deleted");
		Assert.assertEquals("Rider Deleted", repo.deleteRider(1));
	}
	
	@Test
	public void updateRiderTest() {
		Mockito.when(Riders.updateRider(1, MOCK_OBJECT)).thenReturn("Rider Updated");
		Assert.assertEquals("Rider Updated", repo.updateRider(1, MOCK_OBJECT));
	}
	
}
