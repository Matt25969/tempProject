package com.bae.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.bae.persistence.domain.Riders;
import com.bae.util.JSONUtil;

@Default
public class RidersDBRepository implements Riders_Interface {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getRiders() {
		Query query = manager.createQuery("SELECT r FROM Riders r", Riders.class);
		return util.getJSONForObject(query.getResultList());
	}

	public String getSingleRider(int riderID) {
		return util.getJSONForObject(manager.find(Riders.class, riderID));
	}

	@Transactional(REQUIRED)
	public String createRider(String rider) {
		Riders newRider = util.getObjectForJSON(rider, Riders.class);
		manager.persist(newRider);
		return "{\"message\": \"Rider Has Been Succesfully Added To The System\"}";
	}

	@Transactional(REQUIRED)
	public String deleteRider(int riderID) {
		if (manager.contains(manager.find(Riders.class, riderID))) {
			manager.remove(manager.find(Riders.class, riderID));
			return "{\"message\": \"Rider Has Been Succesfully Removed From The System\"}";
		}
	return "{\"message\": \"Rider Has NOT Been Succesfully Removed From The System\"}";
	}

	@Transactional(REQUIRED)
	public String updateRider(int riderID, String rider) {
		Riders transRider = util.getObjectForJSON(rider, Riders.class);
		Riders oldRider = manager.find(Riders.class, riderID);

		if (oldRider != null) {
			oldRider.setFirstName(transRider.getFirstName());
			oldRider.setLastName(transRider.getLastName());
			oldRider.setRiderRaceNumber(transRider.getRiderRaceNumber());
			oldRider.setRiderTeamID(transRider.getRiderTeamID());

			manager.persist(oldRider);
			return "{\"message\": \"Rider Has Been Succesfully Updated\"}";
		}
		return "{\"message\": \"Rider Has NOT Been Succesfully Updated\"}";	
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
}
