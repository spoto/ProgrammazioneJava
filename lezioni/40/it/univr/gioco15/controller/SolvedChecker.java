package it.univr.gioco15.controller;

import it.univr.gioco15.model.Board;

public class SolvedChecker {

	private final boolean isSolved;

	public SolvedChecker(Board board) {
		this.isSolved = checkSolved(board);
	}

	public boolean isSolved() {
		return isSolved;
	}

	private boolean checkSolved(Board board) {
		int width = board.getWidth();
		int height = board.getHeight();

		if (board.getNumberAt(width - 1, height - 1) != 0)
			return false;

		int expected = 1;
		for (int pos = 0; pos < width * height - 1; pos++)
			if (board.getNumberAt(pos % width, pos / width) != expected++)
				return false;

		return true;
	}
}