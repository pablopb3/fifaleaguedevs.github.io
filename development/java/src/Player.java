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
			JSONArray teamPreferencesJSON = (JSONArray) player.get("teamPreferences");
			ArrayList<Integer> teamPreferences = new ArrayList<Integer>();
			for(int j=0; j<teamPreferencesJSON.size(); j++) {
				teamPreferences.add(((Long) teamPreferencesJSON.get(j)).intValue());
				
			}
			new Player(playerName, teamPreferences);	
		}
		return playersJSON;		
	}
	
	public static JSONArray getPlayersJSON() {
		return JsonUtils.getJsonInfo(Constants.PATHS.PLAYERS);
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
