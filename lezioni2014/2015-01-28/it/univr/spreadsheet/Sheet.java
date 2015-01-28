package it.univr.spreadsheet;

public class Sheet {
	private final Cell[][] cells;

	public Sheet(int width, int height) {
		if (width <= 0 || height <= 0)
			throw new IllegalArgumentException("dimensions should be positive");

		this.cells = new Cell[width][height];
		for (int y = 0; y < height; y++)
			for (int x = 0; x < width; x++)
				this.cells[x][y] = new Cell();
	}

	public void setCell(int x, int y, Exp exp) {
		cells[x][y].setExp(exp);
	}

	public Cell getCell(int x, int y) {
		return cells[x][y];
	}

	@Override
	public String toString() {
		String result = "";

		for (int y = 0; y < cells[0].length; y++) {
			result += "|";

			for (int x = 0; x < cells.length; x++) {
				String content = cells[x][y].toString();
				if (content.length() > 10)
					content = content.substring(0, 10);
				result += String.format("%10s|", content);
			}

			result += "\n";
		}

		return result;
	}
}