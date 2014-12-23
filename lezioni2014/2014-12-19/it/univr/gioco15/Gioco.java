package it.univr.gioco15;

import java.util.ArrayList;
import java.util.Random;

public class Gioco {
	private final Tessera[][] tessere;

	public Gioco(FattoriaDiTessere fattoria, int width, int height) {
		tessere = new Tessera[width][height];
		Random random = new Random();
		ArrayList<Tessera> giàGenerate = new ArrayList<>();

		int xVuoto = random.nextInt(width);
		int yVuoto = random.nextInt(height);

		for (int y = 0; y < height; y++)
			for (int x = 0 ; x < width; x++)
				if (x != xVuoto || y != yVuoto) {
					Tessera casuale;
					do {
						casuale = fattoria.mkRandom();
					}
					while (giàGenerate.contains(casuale));

					giàGenerate.add(casuale);
					tessere[x][y] = casuale;
				}
	}

	@Override
	public String toString() {
		String result = "";

		for (int y = 0; y < tessere[0].length; y++) {
			for (int x = 0 ; x < tessere.length; x++)
				if (tessere[x][y] != null)
					result += String.format("%5s ", tessere[x][y]);
				else
					result += "      ";

			result += "\n";
		}

		return result;
	}

	public boolean risolto() {
		Tessera previous = null;
		for (int y = 0; y < tessere[0].length; y++)
			for (int x = 0 ; x < tessere.length; x++) {
				Tessera current = tessere[x][y];
				if (previous != null && current != null && previous.compareTo(current) > 0)
					return false;

				previous = current;
			}

		// casella vuota alla fine
		return previous == null;
	}
}