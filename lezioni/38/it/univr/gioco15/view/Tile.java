package it.univr.gioco15.view;

import javax.swing.JButton;

public abstract class Tile extends JButton {

	protected Tile() {}

	protected Tile(String label) {
		super(label);
	}

	@Override
	public abstract String toString();
}