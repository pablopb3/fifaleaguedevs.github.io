import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Player {
		
	private String name;
	private List<Integer> teamPreferences;
	private Team team;
	private static ArrayList<Player> allPlayers = new ArrayList<Player>();
	
	public Player(String name, List<Integer> teamPreferences) {
		this.name = name;
		this.teamPreferences = teamPreferences;
		allPlayers.add(this);
	}

	public static JSONArray getPlayersFromJSON() {
		
		JSONArray playersJSON = getPlayersJSON();
		for(int i = 0; i<playersJSON.size(); i++) {
			JSONObject player = (JSONObject) playersJSON.get(i);
			String playerName = (String) player.get("name");
			String teamPreferences = (String) player.get("teamPreferences");
			String[] teamPreferencesSplit = teamPreferences.split(",");
			ArrayList teamPreferencesArray = new ArrayList<>();
			for(String teamNumber : teamPreferencesSplit) {
				teamPreferencesArray.add(Integer.valueOf(teamNumber));
			}
		new Player(playerName, teamPreferencesArray);	
		}
		return playersJSON;		
	}
	
	public static JSONArray getPlayersJSON() {
		return JSON_I_O.getJsonInfo(Constants.PATHS.PLAYERS);
	}

	public String getName() {
		return name;
	}

	public List<Integer> getTeamPreferences() {
		return teamPreferences;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTeamPreferences(List<Integer> teamPreferences) {
		this.teamPreferences = teamPreferences;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public static ArrayList<Player> getAllPlayers() {
		return allPlayers;
	}

	public static void setAllPlayers(ArrayList<Player> allPlayers) {
		Player.allPlayers = allPlayers;
	}

}
