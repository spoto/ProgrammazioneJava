package com.hotmoka.examples.swing.slider;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JComponent;

public class StretchableImage extends JComponent {
	private final Image image;
	private double xScaleFactor;
	private double yScaleFactor;

	public StretchableImage(Image image) {
		if (image == null)
			throw new NullPointerException("image cannot be null");

		this.image = image;
		this.xScaleFactor = 1.0;
		this.yScaleFactor = 1.0;
	}

	public void setXScaleFactor(double xScaleFactor) {
		this.xScaleFactor = xScaleFactor;
		revalidate();
	}

	public void setYScaleFactor(double yScaleFactor) {
		this.yScaleFactor = yScaleFactor;
		revalidate();
	}

	private int getScaledWidth() {
		return (int) (image.getWidth(this) * xScaleFactor);
	}

	private int getScaledHeight() {
		return (int) (image.getHeight(this) * yScaleFactor);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(getScaledWidth(), getScaledHeight());
	}

	@Override
	protected void paintComponent(Graphics g) {
		// questo cast è vero da Java 1.2 in poi
		Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(image, 0, 0, getScaledWidth(), getScaledHeight(), null);
	}
}