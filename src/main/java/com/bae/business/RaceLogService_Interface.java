package com.bae.business;

public interface RaceLogService_Interface {
	String getRaceLog();

	String getRaceLogEntry(int entryID);

	String createRaceLogEntry(String raceLogEntry);

	String deleteRaceLogEntry(int entryID);

	String updateRaceLogEntry(int entryID, String raceLogEntry);
}
