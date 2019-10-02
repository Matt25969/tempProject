package com.bae.rest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.business.RaceLogService;
import com.bae.persistence.domain.Teams;

@RunWith(MockitoJUnitRunner.class)
public class RaceLogControllerTest {

	@InjectMocks
	private RaceLogController repo;
	
	@Mock
	RaceLogService racelog;
	
	
	@Test
	public void getRaceLog() {
		Mockito.when(racelog.getRaceLog()).thenReturn("Success");
		Assert.assertEquals("Success", repo.getRaceLog());
	}
	
	@Test
	public void getRaceLogEntry() {
		Mockito.when(racelog.getRaceLogEntry(0)).thenReturn("Success");
		Assert.assertEquals("Success", repo.getRaceLogEntry(0));
	}
	
	@Test
	public void createRaceLogEntry() {
		Mockito.when(racelog.createRaceLogEntry("racelog")).thenReturn("Success");
		Assert.assertEquals("Success", repo.createRaceLogEntry("racelog"));
	}
	
	@Test
	public void deleteRaceLogEntry() {
		Mockito.when(racelog.deleteRaceLogEntry(0)).thenReturn("Success");
		Assert.assertEquals("Success", repo.deleteRaceLogEntry(0));
	}
	
	@Test
	public void updateRaceLogEntry() {
		Mockito.when(racelog.updateRaceLogEntry(0, "racelog")).thenReturn("Success");
		Assert.assertEquals("Success", repo.updateRaceLogEntry(0, "racelog"));
	}
	
	
}
