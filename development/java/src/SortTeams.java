import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.json.simple.JSONArray;

public class SortTeams {
		
	public static void main(String[] args){
		
		JSONArray playersJSON = Player.getPlayersFromJSON();
		Team.getTeamsFromJSON();
		ArrayList<Player> allPlayers = Player.getAllPlayers();
		ArrayList<Team> allTeams = Team.getAllTeams();
		Collections.shuffle(allPlayers);
		pickTeamByOrder(allPlayers, allTeams, playersJSON);
		JSON_I_O.updatePlayersFile(playersJSON);
	}
	
	public static void pickTeamByOrder(ArrayList<Player> allPlayers, ArrayList<Team> allTeams, JSONArray playersJSON) {
	
		for(Player player : allPlayers) {
			List<Integer> teamPreferences = player.getTeamPreferences();
			for(Integer indexOfteamToPick : teamPreferences) {
				Team teamToPick = allTeams.get(indexOfteamToPick);
				if(teamToPick.isAvailable()) {
					setTeamToPlayer(player, teamToPick, playersJSON);
					break;
				} 
			}
		}
	}

	private static void setTeamToPlayer(Player player, Team teamToPick, JSONArray playersJSON) {

		player.setTeam(teamToPick);
		teamToPick.setAvailable(false);
		JSON_I_O.setTeamInOriginalJSON(player, teamToPick, playersJSON);
	}
}
