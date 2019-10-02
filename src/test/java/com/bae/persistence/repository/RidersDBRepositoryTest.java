package com.bae.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.persistence.domain.Riders;
import com.bae.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class RidersDBRepositoryTest {

	@InjectMocks
	private RidersDBRepository repo;
	
	@Mock
	private EntityManager manager;

	@Mock
	private TypedQuery<Object> query;
	
	private JSONUtil util;
	
	//update
	private static final String MOCK_DATA_ARRAY = "[{\"riderID\":1,\"firstName\":\"Jack\",\"lastName\":\"jackson\",\"riderNumber\":55,\"riderTeamID\":2}]";

	private static final String MOCK_OBJECT = "{\"riderID\":1,\"firstName\":\"Jack\",\"lastName\":\"jackson\",\"riderNumber\":55,\"riderTeamID\":2}";
	
	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}
	
	@Test
	public void getRidersTest() {
		
		Mockito.when(manager.createQuery(Mockito.anyString(), Mockito.any())).thenReturn((TypedQuery<Object>) query);
		List<Object> riders = new ArrayList<Object>();
		riders.add(new Riders(1, "Jack", "jackson", 55, 2));
		Mockito.when(query.getResultList()).thenReturn(riders);
//		System.out.println(repo.getRiders());
		Assert.assertEquals(MOCK_DATA_ARRAY, repo.getRiders());
	}
	
	@Test
	public void getSingleRiderTest() {
		List<Object> riders = new ArrayList<Object>();
		Riders r1 = new Riders(1, "Jack", "jackson", 55, 2);
		riders.add(r1);
		Mockito.when(manager.find(Riders.class, 1)).thenReturn(r1);		
//		System.out.println(repo.getSingleRider(1));
		Assert.assertEquals(MOCK_OBJECT, repo.getSingleRider(1));
	}
	
	@Test
	public void createRiderTest() {
		Assert.assertEquals("{\"message\": \"Rider Has Been Succesfully Added To The System\"}", repo.createRider("{\"riderID\":1,\"firstName\":\"Jack\",\"lastName\":\"jackson\",\"riderNumber\":55,\"riderTeamID\":2}"));
	}
	
	@Test
	public void deleteRiderTest() {
		//False Condition
		Assert.assertEquals("{\"message\": \"Rider Has NOT Been Succesfully Removed From The System\"}", repo.deleteRider(1));

		
	}
	
	@Test
	public void deleteRiderTest2() {
		//True Condition
		Mockito.when(manager.contains(Mockito.any())).thenReturn(true);		
		Assert.assertEquals("{\"message\": \"Rider Has Been Succesfully Removed From The System\"}", repo.deleteRider(1));
	}

	@Test
	public void updateRiderTest() {
		//True Condition

		int r2ID = 1;
		Riders r2 = new Riders(1, "Marc", "Marquez", 93, 12);

		Mockito.when(manager.find(Riders.class, r2ID)).thenReturn(r2);
		Assert.assertEquals("{\"message\": \"Rider Has Been Succesfully Updated\"}", repo.updateRider(1, "{\"riderID\":9,\"firstName\":\"Marc\",\"lastName\":\"Marquez\",\"riderNumber\":93,\"riderTeamID\":12}"));
		
		
	}
	
	@Test
	public void updateRiderTest2() {
		//False Condition
		Assert.assertEquals("{\"message\": \"Rider Has NOT Been Succesfully Updated\"}", repo.updateRider(1, "{\"riderID\":9,\"firstName\":\"Marc\",\"lastName\":\"Marquez\",\"riderNumber\":93,\"riderTeamID\":12}"));
	}
	
}
