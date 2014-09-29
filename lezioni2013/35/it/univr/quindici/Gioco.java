package it.univr.quindici;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Gioco {
	private final int width, height;
	private final Tessera[][] tessere;

	public Gioco(FattoriaDiTessere fattoria, int width, int height) {
		this.width = width;
		this.height = height;
		this.tessere = new Tessera[width][height];
		Set<Tessera> viste = new HashSet<Tessera>();
		Random random = new Random();
		int xVuota = random.nextInt(width);
		int yVuota = random.nextInt(height);

		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++)
				if (x != xVuota || y != yVuota)
					// generiamo tessere a caso finché non ne troviamo
					// una mai vista prima
					do {
						tessere[x][y] = fattoria.mkRandom();
					}
					while (!viste.add(tessere[x][y]));
	}

	@Override
	public String toString() {
		String result = "";

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++)
				if (tessere[x][y] != null)
					result += String.format("%5s ", tessere[x][y].toString());
				else
					result += "      ";

			result += "\n";
		}

		return result;
	}

	public boolean risolto() {
		if (tessere[width - 1][height - 1] != null)
			return false;

		for (int pos = 1; pos < width * height - 1; pos++) {
			int x = pos % width, y = pos / width;
			int xPrima = (pos - 1) % width, yPrima = (pos - 1) / width;

			if (tessere[xPrima][yPrima].compareTo(tessere[x][y]) > 0)
				return false;
		}

		return true;
	}
}