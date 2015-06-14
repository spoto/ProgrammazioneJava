package it.univr.life;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private final int width;
	private final int height;
	private final Cell[][] cells;

	public Board(int width, int height, Figure... figures) {
		this.cells = new Cell[width][height];
		this.width = width;
		this.height = height;

		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++)
				cells[x][y] = initAt(x, y, figures);
	}

	protected Cell initAt(int x, int y, Figure... figures) {
		for (Figure figure: figures) {
			Cell cell = figure.mkAliveCellAt(x, y);
			if (cell != null)
				return cell;
		}

		return new Cell(false);
	}

	public void recomputeCells() {
		Cell[][] newCells = new Cell[width][height];

		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++)
				newCells[x][y] = cells[x][y].next(getNeighborsOf(x, y));

		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++)
				cells[x][y] = newCells[x][y];
	}

	private Iterable<Cell> getNeighborsOf(int x, int y) {
		List<Cell> result = new ArrayList<>();
		for (int dx = -1; dx <= 1; dx++)
			for (int dy = -1; dy <= 1; dy++)
				if ((dx != 0 || dy != 0) && x + dx >= 0 && x + dx < width && y + dy >= 0 && y + dy < height)
					result.add(cells[x + dx][y + dy]);

		return result;
	}

	@Override
	public String toString() {
		String result = "";

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++)
				result += cells[x][y].toString();

			result += "\n";
		}

		return result;
	}
}