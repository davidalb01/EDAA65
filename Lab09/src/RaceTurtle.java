import java.util.Random;

public class RaceTurtle extends Turtle {

	private int startNbr;

	public RaceTurtle(RaceWindow w, int nbr) {
		super(w, RaceWindow.getStartXPos(nbr), RaceWindow.getStartYPos(nbr)); //Anropar turtles konstruktor 
		this.startNbr = nbr;					//Dvs skapar ett turtle objekt 
		super.penDown();						//Kan sedan använda turtle klassens metoder med super. 
		super.left(-90);						//Kommandot 
	}

	public void raceStep() {
		Random rand = new Random();
		int stepAmount = rand.nextInt(6) + 1;
		super.forward(stepAmount);
	}

	public String toString() {
		return "Number " + startNbr;
	}

}


