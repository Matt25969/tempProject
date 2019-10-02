package com.bae.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.bae.persistence.domain.Teams;
import com.bae.util.JSONUtil;

@Default
public class TeamsDBRepository implements Teams_Interface {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getTeams() {
		Query query = manager.createQuery("SELECT t FROM Teams t", Teams.class);
		return util.getJSONForObject(query.getResultList());
	}

	public String getSingleTeam(int teamID) {
		return util.getJSONForObject(manager.find(Teams.class, teamID));
	}

	@Transactional(REQUIRED)
	public String createTeam(String team) {
		Teams newTeam = util.getObjectForJSON(team, Teams.class);
		manager.persist(newTeam);
		return "{\"message\"; \"Team Has Been Succesfully Added To The System\"}";
	}

	@Transactional(REQUIRED)
	public String deleteTeam(int teamID) {
		if (manager.contains(manager.find(Teams.class, teamID))) {
			manager.remove(manager.find(Teams.class, teamID));
			return "{\"message\": \"Team Has Been Succesfully Removed From The System\"}";
		}
		return "{\"message\": \"Team Has NOT Been Succesfully Removed From The System\"}";
	}

	@Transactional(REQUIRED)
	public String updateTeam(int teamID, String team) {
		Teams transTeam = util.getObjectForJSON(team, Teams.class);
		Teams oldTeam = manager.find(Teams.class, teamID);

		if (oldTeam != null) {
			oldTeam.setTeamName(transTeam.getTeamName());
			oldTeam.setMotorcycleBrand(transTeam.getMotorcycleBrand());

			manager.persist(oldTeam);
			return "{\"message\": \"Team Has Been Succesfully Updated\"}";
		}
		return "{\"message\": \"Team Has NOT Been Succesfully Updated\"}";
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
