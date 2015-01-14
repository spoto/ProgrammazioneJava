package com.hotmoka.examples.swing.helloWorld;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

public class HelloWorldComponent extends JComponent {
	public final static int MESSAGE_X = 75;
	public final static int MESSAGE_Y = 100;
	public final static int DEFAULT_WIDTH = 300;
	public final static int DEFAULT_HEIGHT = 200;
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawString("Hello World!", MESSAGE_X, MESSAGE_Y);
		g.drawString("Ciao mondo", 150, 140);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	private static final long serialVersionUID = 1L;
}
