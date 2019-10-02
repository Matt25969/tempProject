package com.bae.business;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.persistence.repository.Racelog_Interface;

@RunWith(MockitoJUnitRunner.class)
public class RaceLogServiceTest {

	@InjectMocks
	private RaceLogService repo;
	
	@Mock
	Racelog_Interface Racelog;
	
	private static final String MOCK_OBJECT = "{\"entryID\":1,\"raceNumber\":\"1\",\"raceLocation\":\"TestLocation\", \"riderID\":9, \"teamId\":12, \"racePosition\":1, \"racePoints\":25 }";

	@Test
	public void getRaceLog() {
		Mockito.when(Racelog.getRaceLog()).thenReturn(MOCK_OBJECT);
		Assert.assertEquals(MOCK_OBJECT, repo.getRaceLog());
	}
	
	@Test
	public void getRaceLogEntry() {
		Mockito.when(Racelog.getRaceLogEntry(1)).thenReturn(MOCK_OBJECT);
		Assert.assertEquals(MOCK_OBJECT, repo.getRaceLogEntry(1));
	} 
	
	@Test
	public void createRaceLogEntry() {
		Mockito.when(Racelog.createRaceLogEntry(MOCK_OBJECT)).thenReturn("Team Created");
		Assert.assertEquals("Team Created", repo.createRaceLogEntry(MOCK_OBJECT));
	} 
	
	@Test
	public void deleteRaceLogEntry() {
		Mockito.when(Racelog.deleteRaceLogEntry(1)).thenReturn("Team Deleted");
		Assert.assertEquals("Team Deleted", repo.deleteRaceLogEntry(1));
	}
	
	@Test
	public void updateRaceLogEntry() {
		Mockito.when(Racelog.updateRaceLogEntry(1, MOCK_OBJECT)).thenReturn("Team Updated");
		Assert.assertEquals("Team Updated", repo.updateRaceLogEntry(1, MOCK_OBJECT));
	}
	
}
