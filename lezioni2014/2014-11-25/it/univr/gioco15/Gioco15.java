package it.univr.gioco15;

import java.util.Random;
import java.util.Scanner;

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
		for (int y = 0; y < 4; y++)
			result += String.format("%2d %2d %2d %2d\n",
					caselle[0][y],
					caselle[1][y],
					caselle[2][y],
					caselle[3][y]).replace(" 0", "  ");

		return result;
	}

	public void sposta(int x, int y) {
		provaASinistra(x, y);
		provaADestra(x, y);
		provaSopra(x, y);
		provaSotto(x, y);
	}

	private void provaASinistra(int x, int y) {
		if (x == 0)
			return;
		
		provaASinistra(x-1, y);
		if (caselle[x - 1][y] == 0) {
			// scambio
			caselle[x - 1][y] = caselle[x][y];
			caselle[x][y] = 0;
		}
	}

	private void provaADestra(int x, int y) {
		if (x == 3)
			return;
		
		provaADestra(x + 1, y);
		if (caselle[x + 1][y] == 0) {
			// scambio
			caselle[x + 1][y] = caselle[x][y];
			caselle[x][y] = 0;
		}
	}

	private void provaSotto(int x, int y) {
		if (y == 3)
			return;
		
		provaSotto(x, y + 1);
		if (caselle[x][y + 1] == 0) {
			// scambio
			caselle[x][y + 1] = caselle[x][y];
			caselle[x][y] = 0;
		}
	}

	private void provaSopra(int x, int y) {
		if (y == 0)
			return;
		
		provaSopra(x, y - 1);
		if (caselle[x][y - 1] == 0) {
			// scambio
			caselle[x][y - 1] = caselle[x][y];
			caselle[x][y] = 0;
		}
	}

	public static void main(String[] args) {
		Gioco15 gioco = new Gioco15();
		Scanner s = new Scanner(System.in);
		
		do {
			System.out.println(gioco);
			System.out.print("Inserisci x: ");
			int x = s.nextInt();
			System.out.print("Inserisci y: ");
			int y = s.nextInt();
			gioco.sposta(x, y);
		}
		while (true);
	}
}







