package it.univr.gioco15.view;

public class NumberedTile extends Tile {

	private final int number;

	public NumberedTile(int number) {
		super(String.valueOf(number));

		this.number = number;
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}
}