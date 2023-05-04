package memory;

import se.lth.cs.pt.window.SimpleWindow;

public class MemoryGame {
	public static void main(String[] args) {
		String[] frontFileNames = { "can.jpg", "flopsy_mopsy_cottontail.jpg", "friends.jpg", "mother_ladybird.jpg",
				"mr_mcgregor.jpg", "mrs_rabbit.jpg", "mrs_tittlemouse.jpg", "radishes.jpg" };
		String backFileName = "back.jpg";

		MemoryBoard board = new MemoryBoard(4, backFileName, frontFileNames);
		MemoryWindow window = new MemoryWindow(board);
		int counter = 0;
		window.drawBoard();
		window.waitForMouseClick();
		
		while (!board.hasWon()) {
			window.waitForMouseClick();
			int r1 = window.getMouseRow();
			int c1 = window.getMouseCol();
			while(board.frontUp(r1, c1)) {
				window.waitForMouseClick();
				r1 = window.getMouseRow();
				c1 = window.getMouseCol();
			}
			
			int r2 = window.getMouseRow();
			int c2 = window.getMouseCol();
			while(board.frontUp(r2,c2)) {
				window.waitForMouseClick();
			}
			board.turnCard(r2, c2);
			window.drawCard(r2, c2);
			SimpleWindow.delay(200);
			System.out.println(board.hasWon());
			if (board.same(r1, c1, r2, c2) == true) {
				
			} else {
				board.turnCard(r1, c1);
				window.drawCard(r1, c1);
				board.turnCard(r2, c2);
				window.drawCard(r2, c2);
				counter++;
			}

		}
		System.out.println("You have Won!");
		System.out.println("Nbr of Tries = " + counter);
		
	}
}
