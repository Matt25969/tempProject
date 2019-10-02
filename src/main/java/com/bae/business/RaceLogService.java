package com.bae.business;

import javax.inject.Inject;

import com.bae.persistence.repository.Racelog_Interface;
import com.bae.util.JSONUtil;

public class RaceLogService implements RaceLogService_Interface {

	@Inject
	private JSONUtil util;

	@Inject
	Racelog_Interface RaceLog;

	@Override
	public String getRaceLog() {
		return RaceLog.getRaceLog();
	}

	@Override
	public String getRaceLogEntry(int entryID) {
		return RaceLog.getRaceLogEntry(entryID);
	}

	@Override
	public String createRaceLogEntry(String raceLogEntry) {
		return RaceLog.createRaceLogEntry(raceLogEntry);
	}

	@Override
	public String deleteRaceLogEntry(int entryID) {
		return RaceLog.deleteRaceLogEntry(entryID);
	}

	@Override
	public String updateRaceLogEntry(int entryID, String raceLogEntry) {
		return RaceLog.updateRaceLogEntry(entryID, raceLogEntry);
	}

}
