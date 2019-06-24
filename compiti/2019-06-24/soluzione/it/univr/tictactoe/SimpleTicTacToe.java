package it.univr.tictactoe;

/**
 * Un gioco del tris, in cui il gioco termina solo quando tutte le caselle
 * sono state riempite.
 */
public class SimpleTicTacToe extends TicTacToe {

	@Override
	public boolean isGameOver() {
		for (int x = 1; x <= 3; x++)
			for (int y = 1; y <= 3; y++)
				if (at(x, y) == Tile.EMPTY)
					return false;

		return true;
	}
}