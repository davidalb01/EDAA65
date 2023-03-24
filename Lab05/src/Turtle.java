import se.lth.cs.pt.window.SimpleWindow;

public class Turtle {
    private int headDir; //Direction of Turtle Head
    private double Xcord; //The X coordinates of the Turtles position
    private double Ycord; //The Y coordinates of the Turtles position
    private boolean penStatus;

    // The window in which the turtle will draw
    private SimpleWindow w;

    /** Skapar en sköldpadda som ritar i ritfönstret w. Från början
        befinner sig sköldpaddan i punkten x, y med pennan lyft och
        huvudet pekande rakt uppåt i fönstret (i negativ y-riktning). */
    public Turtle(SimpleWindow w, int x, int y) {
        this.w = w;
        headDir = 90;
        Xcord = x;
        Ycord = y;
        
    }

    /** Sänker pennan. */
    public void penDown() {
        penStatus = true;
    }

    /** Lyfter pennan. */
    public void penUp() {
        penStatus = false;
    }

    /** Går rakt framåt n pixlar i den riktning huvudet pekar. */
    public void forward(int n) {
    	w.moveTo((int)Math.round(Xcord), (int)Math.round(Ycord));
    	double radians = Math.toRadians(headDir);
        double deltaX = Xcord + (n * Math.cos(radians));
        double deltaY = Ycord - (n * Math.sin(radians));
       
        if (penStatus) {
            w.lineTo((int)Math.round(deltaX), (int)Math.round(deltaY));
        }
        Xcord = deltaX;
        Ycord = deltaY;
    }



    /** Vrider beta grader åt vänster runt pennan. */
    public void left(int beta) {
    	headDir = (headDir + beta) % 360;
   
    }

    /** Går till punkten newX, newY utan att rita. Pennans läge (sänkt
        eller lyft) och huvudets riktning påverkas inte. */
    public void jumpTo(int newX, int newY) {
        Xcord = newX;
        Ycord = newY;
        
    }

    /** Återställer huvudriktningen till den ursprungliga. */
    public void turnNorth() {
        headDir = 90;
    }

    /** Tar reda på x-koordinaten för sköldpaddans aktuella position. */
    public int getX() {
        return (int)Math.round(Xcord);
    }

    /** Tar reda på y-koordinaten för sköldpaddans aktuella position. */
    public int getY() {
        return (int)Math.round(Ycord);
    }

    /** Tar reda på sköldpaddans riktning, i grader från den positiva X-axeln. */
    public int getDirection() {
        return (int) Math.round(headDir);
    }
}
