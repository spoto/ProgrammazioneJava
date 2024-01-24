package it.univr.life;

public class Block extends Figure {

	public Block(int startX, int startY) {
		super(startX, startY);
	}

	@Override
	public Cell mkAliveCellAt(int x, int y) {
		x = x - startX;
		y = y - startY;

		return 0 <= x && x <= 1 && 0 <= y && y <= 1 ? new Cell(true) : null;
	}
}