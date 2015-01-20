package com.hotmoka.examples.swing.puzzle15.controller;

import com.hotmoka.examples.swing.puzzle15.ai.Solver;
import com.hotmoka.examples.swing.puzzle15.moves.Mover;
import com.hotmoka.examples.swing.puzzle15.view.View;

public class Puzzle15Controller implements Controller {
	private final View view;
	private final Mover mover;
	private final Solver solver;

	public Puzzle15Controller(View view) {
		this.view = view;
		this.mover = new Mover(view.getModel());
		this.solver = new Solver(view.getModel());

		view.setController(this);
	}

	@Override
	public void onClick(int x, int y) {
		mover.moveAt(x, y);
		if (mover.isSolved())
			view.showSolvedDialog();
	}

	@Override
	public void giveHint() {
		solver.step();
		if (mover.isSolved())
			view.showSolvedDialog();
	}

	@Override
	public void randomize() {
		do {
			mover.randomize();
		}
		while (mover.isSolved());
	}
}