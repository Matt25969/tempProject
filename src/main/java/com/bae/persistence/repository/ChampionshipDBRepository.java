package com.bae.persistence.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.bae.persistence.domain.Championship;
import com.bae.util.JSONUtil;

@Default
public class ChampionshipDBRepository implements Championship_Interface {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getChampionship() {

		Query query = manager.createQuery("SELECT c FROM Championship c", Championship.class);
		return util.getJSONForObject(query.getResultList());

		// Query query = manager.createQuery("SELECT c FROM CHAMPIONSHIP c",
		// Championship.class);
		// return util.getJSONForObject(query.getResultList());

		/*
		 * Plan how to get result from riders log
		 * 
		 * filter racelog by rider id for each position they got >15 add to a counter
		 * i.e. 1st = 0, 2nd = 3 etc...
		 * 
		 * perform multiplication for each and add to a total variable
		 * 
		 * i.e.: 1st = 25 2nd = 20 3rd = 16 4th = 13 5th = 11 6th = 10 7th = 9 8th = 8
		 * 9th = 7 10th = 6 11th = 5 12th = 4 13th = 3 14th = 2 15th = 1 >15th = 0
		 * 
		 * populate championship table by rider id against total points return the table
		 * 
		 * 
		 */

	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
