import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.square.Square;

public class DrawThreeSquares {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "DrawSquare");

		int[] xCord = { 250, 290, 230 }; //Array of diffrent X-cords
		int[] yCord = { 250, 230, 200 }; //Array of diffrent Y-cords
		
		 
		for (int i = 0; i < xCord.length; i++) { //Loops thru the Array 

			Square sq = new Square(xCord[i], yCord[i], 100); //Creates a Square object named sq 
			sq.draw(w); //Draws the square object 
			
		}

	}
}
