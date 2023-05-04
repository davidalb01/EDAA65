package memory;

import java.util.Random;

public class MemoryBoard {
	private int size;
	private MemoryCardImage[][] cards;
	private boolean[][] frontUp;
	private int numPairs;

	/**
	 * Skapar ett memorybräde med size * size kort. backFileName är filnamnet för
	 * filen med baksidesbilden. Vektorn frontFileNames innehåller filnamnen för
	 * frontbilderna.
	 */
	public MemoryBoard(int size, String backFileName, String[] frontFileNames) {
		this.size = size;
		cards = new MemoryCardImage[size][size];
		frontUp = new boolean[size][size];
		createCards(backFileName, frontFileNames);

	}

	/*
	 * Skapar size * size / 2 st memorykortbilder. Placerar ut varje kort på två
	 * slumpmässiga ställen på spelplanen.
	 */
	private void createCards(String backFileName, String[] frontFileNames) {
		Random rand = new Random();
		int r = rand.nextInt(size);
		int c = rand.nextInt(size);
		MemoryCardImage[] pairs = new MemoryCardImage[size * 2];
		for (int i = 0; i < size * 2; i++) {
			pairs[i] = new MemoryCardImage(frontFileNames[i], backFileName);
			for (int j = 0; j < 2; j++) {
				while (!(cards[r][c] == null)) {
					r = rand.nextInt(size);
					c = rand.nextInt(size);
				}
				cards[r][c] = pairs[i];

			}
		}
		numPairs = 0;
	}

	/** Tar reda på brädets storlek. */
	public int getSize() {
		return size;
	}

	/**
	 * Hämtar den tvåsidiga bilden av kortet på rad r, kolonn c. Raderna och
	 * kolonnerna numreras från 0 och uppåt.
	 */
	public MemoryCardImage getCard(int r, int c) {
		return cards[r][c];
	}

	/** Vänder kortet på rad r, kolonn c. */
	public void turnCard(int r, int c) {
		if (frontUp[r][c] == true) {
			frontUp[r][c] = false;
			
		} else {
			frontUp[r][c] = true;
			
		}

	}

	/** Returnerar true om kortet r, c har framsidan upp. */
	public boolean frontUp(int r, int c) {
		if (frontUp[r][c] == true) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Returnerar true om det är samma kort på rad r1, kolonn c2 som på rad r2,
	 * kolonn c2.
	 */
	public boolean same(int r1, int c1, int r2, int c2) {
		if (cards[r1][c1] == cards[r2][c2]) {
			numPairs++;
			return true;

		} else {
			return false;
		}
	}

	/** Returnerar true om alla kort har framsidan upp. */
	public boolean hasWon() {
		if (numPairs == size*2) {
			System.out.println(numPairs);
			return true;
			
		} else {
			return false;
		}

	}
}
