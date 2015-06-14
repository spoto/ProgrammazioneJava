package it.univr.life;

public class Cell {
	private final boolean alive;

	public Cell(boolean alive) {
		this.alive = alive;
	}

	@Override
	public String toString() {
		return alive ? "*" : " ";
	}

	public Cell next(Iterable<Cell> neighbors) {
		int numberOfAliveNeighbors = 0;
		for (Cell neightbor: neighbors)
			if (neightbor.alive)
				numberOfAliveNeighbors++;

		if (!alive && numberOfAliveNeighbors == 3)
			return new Cell(true);
		else if (alive && numberOfAliveNeighbors != 2 && numberOfAliveNeighbors != 3)
			return new Cell(false);

		return this;
	}
}