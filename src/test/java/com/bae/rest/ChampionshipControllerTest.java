package com.bae.rest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.business.ChampionshipService;
//test 3
@RunWith(MockitoJUnitRunner.class)
public class ChampionshipControllerTest {

	@InjectMocks
	private ChampionshipController repo;
	
	@Mock
	ChampionshipService championship;
	
	
	@Test
	public void getChampionship() {
		Mockito.when(championship.getChampionship()).thenReturn("Success");
		Assert.assertEquals("Success", repo.getChampionship());
	}
	
}
