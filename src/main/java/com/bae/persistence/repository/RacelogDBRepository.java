package com.bae.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.bae.persistence.domain.RaceLog;
import com.bae.util.JSONUtil;

@Default
public class RacelogDBRepository implements Racelog_Interface {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getRaceLog() {
		Query query = manager.createQuery("SELECT l FROM RaceLog l", RaceLog.class);
		return util.getJSONForObject(query.getResultList());
	}

	public String getRaceLogEntry(int entryID) {
		return util.getJSONForObject(manager.find(RaceLog.class, entryID));
	}

	@Transactional(REQUIRED)
	public String createRaceLogEntry(String raceLogEntry) {
		RaceLog newEntry = util.getObjectForJSON(raceLogEntry, RaceLog.class);
		manager.persist(newEntry);
		return "{\"message\"; \"Entry Has Been Succesfully Added To The System\"}";
	}

	@Transactional(REQUIRED)
	public String deleteRaceLogEntry(int entryID) {
		if (manager.contains(manager.find(RaceLog.class, entryID))) {
			manager.remove(manager.find(RaceLog.class, entryID));
			return "{\"message\": \"Entry Has Been Succesfully Removed From The System\"}";
		}
		return "{\"message\": \"Entry Has NOT Been Succesfully Removed From The System\"}";
	}

	@Transactional(REQUIRED)
	public String updateRaceLogEntry(int entryID, String raceLogEntry) {
		RaceLog transLog = util.getObjectForJSON(raceLogEntry, RaceLog.class);
		RaceLog oldLog = manager.find(RaceLog.class, entryID);

		if (oldLog != null) {
			oldLog.setRaceNumber(transLog.getRaceNumber());
			oldLog.setRaceLocation(transLog.getRaceLocation());
			oldLog.setRiderID(transLog.getRiderID());
			oldLog.setTeamID(transLog.getTeamID());
			oldLog.setRacePosition(transLog.getRacePosition());
			oldLog.setRacePoints(transLog.getRacePoints());

			manager.persist(oldLog);
			return "{\"message\": \"Entry Has Been Succesfully Updated\"}";
		}
		return "{\"message\": \"Entry Has NOT Been Succesfully Updated\"}";
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
}
