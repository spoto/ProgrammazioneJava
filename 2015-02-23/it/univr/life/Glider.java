package it.univr.life;

public class Glider extends Figure {

	public Glider(int startX, int startY) {
		super(startX, startY);
	}

	@Override
	public Cell mkAliveCellAt(int x, int y) {
		x = x - startX;
		y = y - startY;

		if ((x >= 0 && x <= 2 && y == 0) ||
			(x == 0 && y == 1) ||
			(x == 1 && y == 2))
			return new Cell(true);
		else
			return null;
	}
}