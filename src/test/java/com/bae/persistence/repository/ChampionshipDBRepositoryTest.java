package com.bae.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.persistence.domain.Championship;
import com.bae.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class ChampionshipDBRepositoryTest {

	@InjectMocks
	private ChampionshipDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private TypedQuery<Object> query;

	private JSONUtil util;

	private static final String MOCK_DATA_ARRAY = "[{\"championshipPosition\":1,\"riderTotalPoints\":25,\"riderID\":9,\"teamID\":12}]";

	private static final String MOCK_OBJECT = "{\"championshipPosition\":1,\"riderTotalPoints\":25,\"riderID\":9,\"teamID\":12}";

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	@Test
	public void getChampionshipTest() {

		Mockito.when(manager.createQuery(Mockito.anyString(), Mockito.any())).thenReturn((TypedQuery<Object>) query);
		List<Object> championship = new ArrayList<Object>();
		championship.add(new Championship(1, 25, 9, 12));
		Mockito.when(query.getResultList()).thenReturn(championship);
//		System.out.println(repo.getTeams());
		Assert.assertEquals(MOCK_DATA_ARRAY, repo.getChampionship());
	}

}
