package com.bae.rest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.business.TeamsService;
import com.bae.persistence.domain.Teams;

@RunWith(MockitoJUnitRunner.class)
public class TeamsControllerTest {

	@InjectMocks
	private TeamsController repo;
	
	@Mock
	TeamsService Teams;
	
	
	@Test
	public void getTeamTest() {
		Mockito.when(Teams.getTeams()).thenReturn("Success");
		Assert.assertEquals("Success", repo.getTeams());
	}
	
	@Test
	public void getSingleTeam() {
		Mockito.when(Teams.getSingleTeam(0)).thenReturn("Success");
		Assert.assertEquals("Success", repo.getSingleTeam(0));
	}
	
	@Test
	public void createTeamTest() {
		Mockito.when(Teams.createTeam("team")).thenReturn("Success");
		Assert.assertEquals("Success", repo.createTeam("team"));
	}
	
	@Test
	public void deleteTeamTest() {
		Mockito.when(Teams.deleteTeam(0)).thenReturn("Success");
		Assert.assertEquals("Success", repo.deleteTeam(0));
	}
	
	@Test
	public void updateTeamTest() {
		Mockito.when(Teams.updateTeam(0, "team")).thenReturn("Success");
		Assert.assertEquals("Success", repo.updateTeam(0, "team"));
	}
	
}
