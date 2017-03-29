

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	
	public static JSONArray getJsonInfo(String path) {
		
		JSONArray jsonPlayers = null;
		try {
			InputStream jsonStream = JsonUtils.readJSON(path);
			jsonPlayers = JsonUtils.parseJSON(jsonStream);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonPlayers;
	}

	public static InputStream readJSON(String jsonPath) throws FileNotFoundException {
		
		String jsonAbsolutePath = getParentDirectory();
		File jsonFile = new File(jsonAbsolutePath + jsonPath);
		return new FileInputStream(jsonFile);
	}

	public static JSONArray parseJSON(InputStream is) throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		return	(JSONArray) parser.parse(new InputStreamReader(is));
	}

	public static void setTeamInOriginalJSON(Player player, Team teamToPick, JSONArray playersJSON) {
		for(int i=0; i<playersJSON.size(); i++) {
			JSONObject playerJSON = (JSONObject) playersJSON.get(i);
			if(playerJSON.get("name").equals(player.getName())){
				playerJSON.remove("teamPreferences");
				playerJSON.put("team", teamToPick.getName());
				break;
			}
		}
	}

	public static void updatePlayersFile(JSONArray playersJSON) {

		FileWriter file = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			String prettyPlayersJSON = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(playersJSON);
			file = new FileWriter(getParentDirectory() + Constants.PATHS.PLAYERS_WITH_TEAMS, false);
			file.write(prettyPlayersJSON);
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static String getParentDirectory() {
		
		String parentDirectory = "";
		File file;
		try {
			file = new File("").getCanonicalFile();
			parentDirectory = file.getParentFile().getParent();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return parentDirectory;
	}

}
