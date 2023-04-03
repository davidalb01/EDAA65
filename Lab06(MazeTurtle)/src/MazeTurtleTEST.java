import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;
import java.util.Scanner;
public class MazeTurtleTEST {

	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    System.out.println("Välj Maze 1-5 ");
	    int mazenbr = scan.nextInt();
		Maze m = new Maze(mazenbr);
	    SimpleWindow w = new SimpleWindow(600, 600, "MAZEWALKERTEST");
	    Turtle t = new Turtle(w, 250, 250);
	    	m.draw(w);
	        MazeWalker walker = new MazeWalker(t);
	        walker.walk(m);
	        
	        
	    
	}

}
