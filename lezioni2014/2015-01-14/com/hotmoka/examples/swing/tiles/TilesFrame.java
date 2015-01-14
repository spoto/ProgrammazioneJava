package com.hotmoka.examples.swing.tiles;

import javax.swing.JFrame;

public class TilesFrame extends JFrame {
	private static final long serialVersionUID = 7029971560703923755L;

	public TilesFrame() {
		add(new TilesComponent());
		pack();
	}
}
