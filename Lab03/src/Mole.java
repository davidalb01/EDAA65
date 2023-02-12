public class Mole {
	private Graphics g = new Graphics(30, 50, 10);

	public static void main(String[] args) {
		Mole m = new Mole();
		m.drawWorld();
		m.dig();

	}

	public void drawWorld() {
		g.rectangle(0, 33, 30, 17, Colors.MOLE);
		g.rectangle(0, 14, 30, 1, Colors.GRASS);
		g.rectangle(0, 15, 30, 6, Colors.DIRT);
		g.rectangle(0, 21, 30, 6, Colors.DIRT1);
		g.rectangle(0, 27, 30, 6, Colors.DIRT2);
		// g.rectangle(0, 0, 30, 14, Colors.SKY);
		g.rectangle(0, 0, 30, 2, Colors.SKY);
		g.rectangle(0, 2, 30, 2, Colors.SKY1);
		g.rectangle(0, 4, 30, 2, Colors.SKY2);
		g.rectangle(0, 6, 30, 2, Colors.SKY3);
		g.rectangle(0, 8, 30, 2, Colors.SKY4);
		g.rectangle(0, 10, 30, 2, Colors.SKY5);
		g.rectangle(0, 12, 30, 2, Colors.SKY6); 
	/*	for (int i = 0; i < Colors.skyColors.length; i++) {
		    g.rectangle(0, 2 * i, 30, 2, Colors.skyColors[i]);
		} */
	}

	public void dig() {
		int x = g.getWidth() / 2; // För att börja på mitten
		int y = g.getHeight() / 2;
	
		while (true) {

			if (29 < x) {
				x = 29;
			}
			if (x < 0) {
				x = 0;
			}
			if (49 < y) {
				y = 49;
			}
			if (y < 14) {
				y = 14;
			}

			g.block(x, y, Colors.SOIL);
			char key = g.waitForKey();
			if (y == 14) {
				g.block(x, y, Colors.GRASS);
				} else {
				g.block(x, y, Colors.TUNNEL);
				}

			if (key == 'w') {
				y -= 1;
			} else if (key == 'a') {
				x -= 1;
			} else if (key == 's') {
				y += 1;
			} else if (key == 'd') {
				x += 1;
			}
			System.out.println("X värdet: =" +x);
			System.out.println("Y värdet: ="+y);

		}

	}

}

