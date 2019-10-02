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

import com.bae.persistence.domain.Teams;
import com.bae.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class TeamsDBRepositoryTest {

	@InjectMocks
	private TeamsDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private TypedQuery<Object> query;

	private JSONUtil util;

	private static final String MOCK_DATA_ARRAY = "[{\"teamID\":1,\"teamName\":\"testTeam\",\"motorcycleBrand\":\"testBrand\"}]";

	private static final String MOCK_OBJECT = "{\"teamID\":1,\"teamName\":\"testTeam\",\"motorcycleBrand\":\"testBrand\"}";

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	@Test
	public void getTeamsTest() {

		Mockito.when(manager.createQuery(Mockito.anyString(), Mockito.any())).thenReturn((TypedQuery<Object>) query);
		List<Object> teams = new ArrayList<Object>();
		teams.add(new Teams(1, "testTeam", "testBrand"));
		Mockito.when(query.getResultList()).thenReturn(teams);
//		System.out.println(repo.getTeams());
		Assert.assertEquals(MOCK_DATA_ARRAY, repo.getTeams());
	}

	@Test
	public void getSingleTeamTest() {

		List<Object> riders = new ArrayList<Object>();
		Teams t1 = new Teams(1, "testTeam", "testBrand");
		riders.add(t1);
		Mockito.when(manager.find(Teams.class, 1)).thenReturn(t1);
//		System.out.println(repo.getSingleRider(1));
		Assert.assertEquals(MOCK_OBJECT, repo.getSingleTeam(1));
	}

	@Test
	public void createTeamTest() {
		Assert.assertEquals("{\"message\"; \"Team Has Been Succesfully Added To The System\"}",
				repo.createTeam("{\"teamID\":1,\"teamName\":\"testTeam\",\"motorcycleBrand\":\"testBrand\"}"));
	}

	@Test
	public void deleteTeamTest() {
		// False Condition
		Assert.assertEquals("{\"message\": \"Team Has NOT Been Succesfully Removed From The System\"}",
				repo.deleteTeam(1));
	}

	@Test
	public void deleteTeamTest2() {
		// True Condition
		Mockito.when(manager.contains(Mockito.any())).thenReturn(true);
		Assert.assertEquals("{\"message\": \"Team Has Been Succesfully Removed From The System\"}", repo.deleteTeam(1));
	}

	@Test
	public void updateTeamTest() {
		// True Condition

		int t2ID = 1;
		Teams t2 = new Teams(1, "test", "team");

		Mockito.when(manager.find(Teams.class, t2ID)).thenReturn(t2);
		Assert.assertEquals("{\"message\": \"Team Has Been Succesfully Updated\"}",
				repo.updateTeam(1, "{\"teamID\":1,\"teamName\":\"testTeam\",\"motorcycleBrand\":\"testBrand\"}"));
	}

	@Test
	public void updateTeamTest2() {
		// False Condition
		Assert.assertEquals("{\"message\": \"Team Has NOT Been Succesfully Updated\"}",
				repo.updateTeam(1, "{\"teamID\":1,\"teamtwoName\":\"testTeam\",\"motorcycleBrand\":\"testBrand\"}"));
	}

}
