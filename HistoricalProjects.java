package application;

import java.util.HashMap;
import java.util.List;

public class HistoricalProjects {
	private HashMap<String, List<String>> database;
	
	public HashMap<String, List<String>> getHistoricalProjects() {
		return database;
	}
	
	public void setHistoricalProjects(HashMap<String, List<String>> newDatabase) {
		database = newDatabase;
	}
}
