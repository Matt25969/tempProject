package com.bae.persistence.repository;

public interface Racelog_Interface {
	
	String getRaceLog();
	String getRaceLogEntry(int entryID);
	String createRaceLogEntry(String raceLogEntry);
	String deleteRaceLogEntry(int entryID);
	String updateRaceLogEntry(int entryID, String raceLogEntry);
}
