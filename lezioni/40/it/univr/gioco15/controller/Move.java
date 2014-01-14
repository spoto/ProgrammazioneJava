package it.univr.gioco15.controller;

import it.univr.gioco15.model.Board;

public class Move {

	private final Board board;
	private final boolean legal;

	public Move(Board board, int x, int y) {
		this.board = board;
		this.legal = performMoveAt(x, y);
	}

	public boolean isLegal() {
		return legal;
	}

	private boolean performMoveAt(int x, int y) {
		return leftwards(x, y) || rightwards(x, y) || upwards(x, y) || downwards(x, y);
	}

	private boolean downwards(int x, int y) {
        if (x >= 0 && x < board.getWidth() && y >= 0 && y < board.getHeight() - 1) {
        	downwards(x, y + 1);
        	if (board.getNumberAt(x, y + 1) == 0) {
        		board.setNumberAt(x, y + 1, board.getNumberAt(x, y));
        		board.setNumberAt(x, y, 0);
        		return true;
        	}
        }

        return false;
	}

	private boolean upwards(int x, int y) {
        if (x >= 0 && x < board.getWidth() && y > 0 && y < board.getHeight()) {
        	upwards(x, y - 1);
        	if (board.getNumberAt(x, y - 1) == 0) {
        		board.setNumberAt(x, y - 1, board.getNumberAt(x, y));
        		board.setNumberAt(x, y, 0);
        		return true;
        	}
        }

        return false;
	}

	private boolean leftwards(int x, int y) {
        if (x > 0 && x < board.getWidth() && y >= 0 && y < board.getHeight()) {
        	leftwards(x - 1, y);
        	if (board.getNumberAt(x - 1, y) == 0) {
        		board.setNumberAt(x - 1, y, board.getNumberAt(x, y));
        		board.setNumberAt(x, y, 0);
        		return true;
        	}
        }

        return false;
	}

	private boolean rightwards(int x, int y) {
		if (x >= 0 && x < board.getWidth() - 1 && y >= 0 && y < board.getHeight()) {
			rightwards(x + 1, y);
			if (board.getNumberAt(x + 1, y) == 0) {
				board.setNumberAt(x + 1, y, board.getNumberAt(x, y));
				board.setNumberAt(x, y, 0);
				return true;
			}
        }

		return false;
	}
}