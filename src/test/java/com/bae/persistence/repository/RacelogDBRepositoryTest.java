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

import com.bae.persistence.domain.RaceLog;
import com.bae.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)

public class RacelogDBRepositoryTest {
	@InjectMocks
	private RacelogDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private TypedQuery<Object> query;

	private JSONUtil util;

	private static final String MOCK_DATA_ARRAY = "[{\"entryID\":1,\"raceNumber\":1,\"raceLocation\":\"Test Race Location\",\"riderID\":9,\"teamID\":12,\"racePosition\":1,\"racePoints\":25}]";

	private static final String MOCK_OBJECT = "{\"entryID\":1,\"raceNumber\":1,\"raceLocation\":\"Test Race Location\",\"riderID\":9,\"teamID\":12,\"racePosition\":1,\"racePoints\":25}";

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	@Test
	public void getRaceLogTest() {

		Mockito.when(manager.createQuery(Mockito.anyString(), Mockito.any())).thenReturn((TypedQuery<Object>) query);
		List<Object> raceLog = new ArrayList<Object>();
		raceLog.add(new RaceLog(1, 1, "Test Race Location", 9, 12, 1, 25));
		Mockito.when(query.getResultList()).thenReturn(raceLog);
//		System.out.println(repo.getRaceLog());
		Assert.assertEquals(MOCK_DATA_ARRAY, repo.getRaceLog());
	}

	@Test
	public void getRaceLogEntryTest() {

		List<Object> raceLog = new ArrayList<Object>();
		RaceLog r1 = new RaceLog(1, 1, "Test Race Location", 9, 12, 1, 25);
		raceLog.add(r1);
		Mockito.when(manager.find(RaceLog.class, 1)).thenReturn(r1);
//		System.out.println(repo.getSingleRider(1));
		Assert.assertEquals(MOCK_OBJECT, repo.getRaceLogEntry(1));
	}

	@Test
	public void createRaceLogEntryTest() {
		Assert.assertEquals("{\"message\"; \"Entry Has Been Succesfully Added To The System\"}",
				repo.createRaceLogEntry(
						"{\"entryID\":1,\"raceNumber\":1,\"raceLocation\":\"Test Race Location\",\"riderID\":9,\"teamID\":12,\"racePosition\":1,\"racePoints\":25}"));
	}

	@Test
	public void deleteRaceLogEntryTest() {
		// False Condition
		Assert.assertEquals("{\"message\": \"Entry Has NOT Been Succesfully Removed From The System\"}",
				repo.deleteRaceLogEntry(1));
	}

	@Test
	public void deleteRaceLogEntryTest2() {
		// True Condition
		Mockito.when(manager.contains(Mockito.any())).thenReturn(true);
		Assert.assertEquals("{\"message\": \"Entry Has Been Succesfully Removed From The System\"}",
				repo.deleteRaceLogEntry(1));
	}

	@Test
	public void updateTeamTest() {
		// True Condition

		int r2ID = 1;
		RaceLog r2 = new RaceLog(1, 1, "Test Race Location", 9, 12, 1, 25);

		Mockito.when(manager.find(RaceLog.class, r2ID)).thenReturn(r2);
		Assert.assertEquals("{\"message\": \"Entry Has Been Succesfully Updated\"}", repo.updateRaceLogEntry(1,
				"{\"entryID\":1,\"raceNumber\":1,\"raceLocation\":\"Test Race Location\",\"riderID\":9,\"teamID\":12,\"racePosition\":1,\"racePoints\":25}"));

	}

	@Test
	public void updateTeamTest2() {
		// False Condition
		Assert.assertEquals("{\"message\": \"Entry Has NOT Been Succesfully Updated\"}", repo.updateRaceLogEntry(1,
				"{\"entryID\":1,\"raceNumber\":1,\"raceLocation\":\"Test Race Location\",\"riderID\":9,\"teamID\":12,\"racePosition\":1,\"racePoints\":25}"));
	}

}
