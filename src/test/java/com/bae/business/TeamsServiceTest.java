package com.bae.business;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.persistence.repository.Riders_Interface;
import com.bae.persistence.repository.Teams_Interface;

@RunWith(MockitoJUnitRunner.class)
public class TeamsServiceTest {

	@InjectMocks
	private TeamsService repo;
	
	@Mock
	Teams_Interface Teams;
	
	private static final String MOCK_OBJECT = "{\"teamID\":1,\"teamName\":\"team\",\"motorcycleBrand\":\"teamBrand\"}";

	@Test
	public void getTeamTest() {
		Mockito.when(Teams.getTeams()).thenReturn(MOCK_OBJECT);
		Assert.assertEquals(MOCK_OBJECT, repo.getTeams());
	}
	
	@Test
	public void getSingleTeamTest() {
		Mockito.when(Teams.getSingleTeam(1)).thenReturn(MOCK_OBJECT);
		Assert.assertEquals(MOCK_OBJECT, repo.getSingleTeam(1));
	} 
	
	@Test
	public void createTeamTest() {
		Mockito.when(Teams.createTeam(MOCK_OBJECT)).thenReturn("Team Created");
		Assert.assertEquals("Team Created", repo.createTeam(MOCK_OBJECT));
	} 
	
	@Test
	public void deleteTeamTest() {
		Mockito.when(Teams.deleteTeam(1)).thenReturn("Team Deleted");
		Assert.assertEquals("Team Deleted", repo.deleteTeam(1));
	}
	
	@Test
	public void updateTeamTest() {
		Mockito.when(Teams.updateTeam(1, MOCK_OBJECT)).thenReturn("Team Updated");
		Assert.assertEquals("Team Updated", repo.updateTeam(1, MOCK_OBJECT));
	}
	
}
