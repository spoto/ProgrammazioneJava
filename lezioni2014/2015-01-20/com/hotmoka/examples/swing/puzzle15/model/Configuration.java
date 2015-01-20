package com.hotmoka.examples.swing.puzzle15.model;

public interface Configuration {

	/**
	 * Yields the label on the tile at the given coordinates
	 * 
	 * @param x the horizontal coordinate, between 0 and 3
	 * @param y the vertical coordinate, between 0 and 3
	 * @return the label, between 0 and 15. 0 means that the position is empty
	 */

	int at(int x, int y);

	/**
	 * Yields a new configuration where a tile has been swapped
	 * with another tile. This configuration remains unchanged
	 * 
	 * @param fromX the horizontal coordinate of the first tile, between 0 and 3
	 * @param fromY the vertical coordinate of the first tile, between 0 and 3
	 * @param intoX the horizontal coordinate of the second tile, between 0 and 3
	 * @param intoY the vertical coordinate of the second tile, between 0 and 3
	 * @return the resulting configuration
	 */

	Configuration swap(int fromX, int fromY, int intoX, int intoY);
}