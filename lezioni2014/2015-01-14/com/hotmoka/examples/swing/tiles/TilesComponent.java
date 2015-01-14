package com.hotmoka.examples.swing.tiles;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class TilesComponent extends JComponent {
	private static final long serialVersionUID = 1L;
	public final static int DEFAULT_WIDTH = 500;
	public final static int DEFAULT_HEIGHT = 300;
	private final Image image;

	public TilesComponent() {
		image = new ImageIcon("img/pika.png").getImage();
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (image == null)
			return;

		int imageWidth = image.getWidth(this);
		int imageHeight = image.getHeight(this);

		g.drawImage(image, 0, 0, null);

		for (int i = 0; i <= getWidth(); i+= imageWidth)
			for (int j = 0; j <= getHeight(); j+= imageHeight)
				g.copyArea(0, 0, imageWidth, imageHeight, i, j);
	}
}


