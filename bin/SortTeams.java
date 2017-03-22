import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SortTeams {
		
	public static void main(String[] args){
		List<String> players = Arrays.asList("Abderra", "Matheus", "Carles", "Poqueto");
		List<String> teams = new ArrayList(Arrays.asList("Barça", "Madrid", "Atleti", "Arsenal"));

		for(String player : players){
			int randomNum = ThreadLocalRandom.current().nextInt(0, teams.size());
			System.out.println("Player " + player + " tiene el equipo " + teams.get(randomNum));
			teams.remove(randomNum);
		}
	}

}
