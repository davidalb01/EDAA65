
import java.util.ArrayList;

public class TurtleRace {

	public static void main(String[] args) {
		ArrayList<RaceTurtle> contestants = new ArrayList<RaceTurtle>();
		ArrayList<RaceTurtle> winners = new ArrayList<RaceTurtle>();
		RaceWindow w = new RaceWindow();
		for (int i = 1; i <= 8; i++) {
			contestants.add(new RaceTurtle(w, i));
		}
		w.waitForMouseClick();

		while (!contestants.isEmpty()) {
			for (RaceTurtle t : contestants) {
				t.raceStep();
				RaceWindow.delay(1);
			}
			for (int i = 0; i < contestants.size(); i++) {
				if (contestants.get(i).getX() >= RaceWindow.X_END_POS) {
					winners.add(contestants.get(i));
					contestants.remove(i);
				}
			}
		}
		String[]prefix = {"st","nd","rd"};
		for (int i = 0; i < 3; i++) {
			System.out.println((i + 1)+prefix[i] +" Place :" + winners.get(i));
		}

	}

}