package com.bae.business;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.persistence.repository.Championship_Interface;
import com.bae.persistence.repository.Racelog_Interface;

@RunWith(MockitoJUnitRunner.class)
public class ChampionshipServiceTest {

	@InjectMocks
	private ChampionshipService repo;
	
	@Mock
	Championship_Interface Racelog;
	
	@Test
	public void getChampionship() {
		Mockito.when(Racelog.getChampionship()).thenReturn("Championship");
		Assert.assertEquals("Championship", repo.getChampionship());
	}
	
	
	
}
