import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RetrievePlayersInfoFromFifaAPI {

	public static String playersPath = JsonUtils.getParentDirectory() + "/fifaPlayers.json";
	
	public static void main(String[] args) {

		GetPlayersJson();

	}

	private static boolean GetPlayersJson() {

		String jsonPlayersPageI = "";
		for (int page = 1; page <= 671; page++) {
			jsonPlayersPageI = GetPlayersJsonPage(page);
			savePlayersFromLeagueTeams(jsonPlayersPageI);
		}
		changeFirstCharacter();
		writeInPlayersFile("]");
		return true;
	}

	private static String GetPlayersJsonPage(int page) {

		StringBuilder result = new StringBuilder();
		URL url;

		try {
			System.out.println(page);
			url = new URL("https://www.easports.com/fifa/ultimate-team/api/fut/item?page=" + String.valueOf(page));
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			rd.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result.toString();
	}

	private static boolean savePlayersFromLeagueTeams(String jsonPlayersPageI) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(jsonPlayersPageI);

			for (int i = 0; i < root.path("count").intValue(); i++) {
				JsonNode player = root.path("items").get(i);
				savePlayerIfFromLeagueTeam(player);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	private static void savePlayerIfFromLeagueTeam(JsonNode player) {
		// TODO Auto-generated method stub
		Team.getTeamsFromJSON();
		ArrayList<Team> allTeams = Team.getAllTeams();

		try {

			Integer teamId = player.path("club").path("id").intValue();

			for (Team team : allTeams) {
				if (teamId == team.getId()) {
					System.out.println(player.toString());
					writeInPlayersFile("," + player.toString());
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void writeInPlayersFile(String str) {

		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter(playersPath, true));
			bw.write(str);
			bw.newLine();
			bw.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	private static void changeFirstCharacter() {
		try {
			
	        // input the file content to the StringBuffer "input"
	        BufferedReader file = new BufferedReader(new FileReader(playersPath));
	        String line;
	        StringBuffer inputBuffer = new StringBuffer();

	        while ((line = file.readLine()) != null) {
	            inputBuffer.append(line);
	            inputBuffer.append('\n');
	        }
	        String inputStr = inputBuffer.toString();

	        file.close();

	        inputStr = inputStr.replaceFirst(",","["); 

	        // write the new String with the replaced line OVER the same file
	        FileOutputStream fileOut = new FileOutputStream(playersPath);
	        fileOut.write(inputStr.getBytes());
	        fileOut.close();

	    } catch (Exception e) {
	        System.out.println("Problem reading file.");
	    }
	}
}
