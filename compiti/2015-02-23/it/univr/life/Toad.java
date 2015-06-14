package it.univr.life;

public class Toad extends Figure {

	public Toad(int startX, int startY) {
		super(startX, startY);
	}

	@Override
	public Cell mkAliveCellAt(int x, int y) {
		x = x - startX;
		y = y - startY;

		return (1 <= x && x <= 3 && y == 0) || (0 <= x && x <= 2 && y == 1) ? new Cell(true) : null;
	}
}