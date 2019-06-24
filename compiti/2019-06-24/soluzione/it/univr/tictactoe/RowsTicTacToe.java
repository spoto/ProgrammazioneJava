package it.univr.tictactoe;

/**
 * Un gioco del tris, in cui il gioco termina quando tutte le caselle
 * sono state riempite oppure quando un giocatore ha piazzato tre
 * simboli uguali su una riga o su una colonna.
 */
public class RowsTicTacToe extends SimpleTicTacToe {

	@Override
	public boolean isGameOver() {
		// righe
		for (int y = 1; y <= 3; y++)
			if (at(1, y) != Tile.EMPTY && at(1, y) == at(2, y) && at(2, y) == at(3, y))
				return true;

		// colonne
		for (int x = 1; x <= 3; x++)
			if (at(x, 1) != Tile.EMPTY && at(x, 1) == at(x, 2) && at(x, 2) == at(x, 3))
				return true;

		// oppure tutte le caselle sono riempite
		return super.isGameOver();
	}
}