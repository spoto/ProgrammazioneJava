package it.univr.life;

public class Ship extends Figure {

	public Ship(int startX, int startY) {
		super(startX, startY);
	}

	@Override
	public Cell mkAliveCellAt(int x, int y) {
		x = x - startX;
		y = y - startY;

		if ((x == 0 && y == 0) ||
			(x == 1 && y == 0) ||
			(x == 0 && y == 1) ||
			(x == 2 && y == 1) ||
			(x == 1 && y == 2))
			return new Cell(true);
		else
			return null;
	}
}