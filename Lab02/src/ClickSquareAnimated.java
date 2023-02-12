import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class ClickSquareAnimated {

	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "ClickSquareAnimated");
		
		int startingX = 250; 
		int startingY = 250;
		Square sq = new Square(startingX, startingY, 100);
		while (true) { //Following code runs until program is stopped
			w.waitForMouseClick(); // Waits for mouseclick

			sq.erase(w);
			
			int x = w.getMouseX() - startingX;
			int y = w.getMouseY() - startingY;

			for (int i = 0; i < 10; i++) { // Draws 10 number of squares
				sq.move(x / 10, y / 10); // Moves the cursor x/10 steps in X and y/10 in y
				sq.draw(w); // Draws a square where the cursor is
				SimpleWindow.delay(50); // Waits 50 ms
				sq.erase(w); // erases the square
			}
			startingX = sq.getX(); // Gets the xcords and y cord of the last square drawn
			startingY = sq.getY(); // and saves it as the starting cords
			w.moveTo(startingX, startingY);
			sq.draw(w); // And draws it up

		}
	}

}
