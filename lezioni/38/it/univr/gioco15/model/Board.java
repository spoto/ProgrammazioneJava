package it.univr.gioco15.model;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Board {

	private final static Random random = new Random();

	private final int width;
	private final int height;
	private final int[][] cells;

	/**
	 * Crea una scacchiera a caso.
	 */

	public Board(int width, int height) {
		this.width = width;
		this.height = height;
		this.cells = new int[width][height];

		int emptyX = random.nextInt(width);
		int emptyY = random.nextInt(height);

		Set<Integer> seen = new HashSet<Integer>();
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++)
				if (x != emptyX || y != emptyY) {
					int number;
					
					do {
						number = 1 + random.nextInt(width * height - 1);
					}
					while (seen.contains(number));

					seen.add(cells[x][y] = number);
				}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getNumberAt(int x, int y) {
		return cells[x][y];
	}
}