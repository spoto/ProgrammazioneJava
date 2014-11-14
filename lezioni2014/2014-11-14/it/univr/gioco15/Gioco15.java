package it.univr.gioco15;

import java.util.Random;

public class Gioco15 {

	// 0 indica la casella vuota
	private final int[][] caselle = new int[4][4];
	private final static Random random = new Random();

	public Gioco15() {
		for (int num = 1; num <= 15; num++)
			posizionaACaso(num);
	}

	private void posizionaACaso(int num) {
		int x, y;
		do {
			x = random.nextInt(4);
			y = random.nextInt(4);
		}
		while (caselle[x][y] != 0);
		
		caselle[x][y] = num;
	}

	public String toString() {
		String result = "";
		for (int x = 0; x < 4; x++)
			result += String.format("%2d %2d %2d %2d\n",
					caselle[x][0],
					caselle[x][1],
					caselle[x][2],
					caselle[x][3]).replace(" 0", "  ");

		return result;
	}

	public void sposta(int x, int y) {
		provaASinistra(x, y);
		provaADestra(x, y);
		provaSopra(x, y);
		provaSotto(x, y);
	}

	private boolean provaASinistra(int x, int y) {
		
	}
}
