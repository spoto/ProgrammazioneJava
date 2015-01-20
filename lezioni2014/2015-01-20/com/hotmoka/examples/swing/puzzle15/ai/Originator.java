package com.hotmoka.examples.swing.puzzle15.ai;

import com.hotmoka.examples.swing.puzzle15.model.Configuration;

public class Originator {
	public final Configuration previous;
	public final int steps;
	
	public Originator(Configuration previous, int steps) {
		this.previous = previous;
		this.steps = steps;
	}
}