package com.hotmoka.examples.swing.puzzle15.ai;

import com.hotmoka.examples.swing.puzzle15.model.Model;

public class Solver {
	private final Model model;
	private Steps steps;

	public Solver(Model model) {
		this.model = model;
	}

	public void step() {
		if (steps == null || !steps.head.equals(model.getConfiguration()))
			steps = new Solution(model.getConfiguration()).getSequenceOfSteps();

		steps = steps.tail;
		model.setConfiguration(steps.head);
	}
}