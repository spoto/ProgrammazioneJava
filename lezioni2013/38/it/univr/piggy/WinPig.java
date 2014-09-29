package it.univr.piggy;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class WinPig extends JFrame {

	private static final int HEIGHT = 400;
	private static final int WIDTH = 400;

	public WinPig() {
		super("Piggy!");

		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel subtitle = addSubtitle();
		addPiggy(subtitle);
	}

	private JLabel addSubtitle() {
		JLabel subtitle = new JLabel();
		subtitle.setHorizontalAlignment(SwingConstants.CENTER);
		add(subtitle, BorderLayout.SOUTH);

		return subtitle;
	}

	private void addPiggy(JLabel subtitle) {
		add(new Piggy(subtitle), BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		new WinPig().setVisible(true);
	}
}