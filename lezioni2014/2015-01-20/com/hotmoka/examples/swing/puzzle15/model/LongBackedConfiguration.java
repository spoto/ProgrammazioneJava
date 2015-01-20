package com.hotmoka.examples.swing.puzzle15.model;

public class LongBackedConfiguration extends AbstractConfiguration {
	private long tiles;

	private LongBackedConfiguration(long tiles) {
		this.tiles = tiles;
	}

	public LongBackedConfiguration() {
		this.tiles = 0L;

		int value = 1;
		for (int y = 0; y < 4; y++)
			for (int x = 0; x < 4; x++)
				if (x != 3 || y != 3)
					set(x, y, value++);
	}

	@Override
	public int at(int x, int y) {
		return (int) ((tiles >> (y * 16 + x * 4)) & 0x0000000f);
	}

	private void set(int x, int y, int value) {
		tiles ^= tiles & (0x0000000fL << (y * 16 + x * 4));
		tiles |= ((long) value) << (y * 16 + x * 4);
	}

	@Override
	public Configuration swap(int fromX, int fromY, int intoX, int intoY) {
		LongBackedConfiguration result = new LongBackedConfiguration(tiles);

		int intoValue = at(intoX, intoY);
		int fromValue = at(fromX, fromY);
		result.set(intoX, intoY, fromValue);
		result.set(fromX, fromY, intoValue);

		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof LongBackedConfiguration)
			return tiles == ((LongBackedConfiguration) other).tiles;
		else
			return super.equals(other);
	}
}