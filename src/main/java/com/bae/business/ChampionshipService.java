package com.bae.business;

import javax.inject.Inject;

import com.bae.persistence.domain.Championship;
import com.bae.persistence.repository.Championship_Interface;
import com.bae.persistence.repository.Racelog_Interface;
import com.bae.util.JSONUtil;

public class ChampionshipService implements ChampionshipService_Interface {

	@Inject
	private JSONUtil util;

	@Inject
	Championship_Interface Championship;
	

	@Override
	public String getChampionship() {
		return Championship.getChampionship();
	}
}
