package it.univr.life;

public class Blinker extends Figure {

	public Blinker(int startX, int startY) {
		super(startX, startY);
	}

	@Override
	public Cell mkAliveCellAt(int x, int y) {
		x = x - startX;
		y = y - startY;

		return 0 <= x && x <= 2 && y == 0 ? new Cell(true) : null;
	}
}