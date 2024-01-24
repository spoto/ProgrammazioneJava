package it.univr.tictactoe;

/**
 * Un gioco del tris, in cui il gioco termina quando tutte le caselle
 * sono state riempite oppure quando un giocatore ha piazzato tre
 * simboli uguali su una riga o su una colonna o su una diagonale.
 */
public class FullTicTacToe extends RowsTicTacToe {

	@Override
	public boolean isGameOver() {
		// prima diagonale
		if (at(1, 1) != Tile.EMPTY && at(1, 1) == at(2, 2) && at(2, 2) == at(3, 3))
			return true;

		// seconda diagonale
		if (at(3, 1) != Tile.EMPTY && at(3, 1) == at(2, 2) && at(2, 2) == at(1, 3))
			return true;

		// oppure righe, colonne o tutte le caselle sono riempite
		return super.isGameOver();
	}
}