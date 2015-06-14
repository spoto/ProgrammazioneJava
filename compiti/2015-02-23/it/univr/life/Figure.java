package it.univr.life;

public abstract class Figure {
	protected final int startX;
	protected final int startY;
	
	protected Figure(int startX, int startY) {
		this.startX = startX;
		this.startY = startY;
	}

	public abstract Cell mkAliveCellAt(int x, int y);
}