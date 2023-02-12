import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class Draw10Squares {

	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "Draw10Squares");//Creates a Window 
		int oldX = 250;		//X Startingpoint						// That's 600 by 600px 
		int oldY = 250;	 	//Y startingpoint					   //With the title Draw10Squares

		while (true) { //Loops until program is stopped 
			w.waitForMouseClick(); // Waits for mouseclick from user

			Square sq1 = new Square(oldX, oldY, 100); 
			//Creates a square object 
			sq1.erase(w); //Erases sq1 in the Window w
			int x = w.getMouseX() - oldX; // gets the x cord of mouseclick and subtracts the startingpoint value
			int y = w.getMouseY() - oldY; // gets the y cord of mouseclick and subtracts the startingpoint value

			for (int i = 0; i < 10; i++) { // Draws 10 number of squares
				sq1.move(x / 10, y / 10); // Moves the x/10 steps in X-Direction and  y/10 in Y-Direction
				sq1.draw(w); // Draws the square
				SimpleWindow.delay(50); // Waits 50 ms

			}

		}
	}

}
