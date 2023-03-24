import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;
public class MazeTurtleTEST {

	public static void main(String[] args) {
	    Maze m = new Maze(5);
	    SimpleWindow w = new SimpleWindow(600, 600, "MAZEWALKERTEST");
	    Turtle t = new Turtle(w, 250, 250);
	    
	        w.clear(); // Clear the window
	        m.draw(w);
	        MazeWalker walker = new MazeWalker(t);
	        walker.walk(m);
	        t.penDown();
	        m.draw(w);
	        
	    
	}

}
