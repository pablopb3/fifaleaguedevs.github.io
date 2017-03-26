import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Team {
		
	private String name;
	private boolean available = true;
	private static ArrayList<Team> allTeams = new ArrayList<Team>();
	
	public Team(String name) {
		this.name = name;
		allTeams.add(this);
	}

	public static void getTeamsFromJSON() {
		
		JSONArray teamsJSON = getTeamsJSON();
		for(int i=0; i<teamsJSON.size();i++) {
			JSONObject team = (JSONObject) teamsJSON.get(i);
			String teamName = (String) team.get("team");
			new Team(teamName);
		}
		return;
	}
	
	public static JSONArray getTeamsJSON() {
		return JSON_I_O.getJsonInfo(Constants.PATHS.TEAMS);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public static ArrayList<Team> getAllTeams() {
		return allTeams;
	}

	public static void setAllTeams(ArrayList<Team> allTeams) {
		Team.allTeams = allTeams;
	}

}
