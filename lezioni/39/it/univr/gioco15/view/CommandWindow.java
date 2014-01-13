package it.univr.gioco15.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CommandWindow extends JFrame {

	private static final int HEIGHT = 150;
	private static final int WIDTH = 300;

	private final JLabel message = new JLabel();

	public CommandWindow() {
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		message.setHorizontalAlignment(SwingConstants.CENTER);
		add(message);
	}

	public void setMessage(String text) {
		message.setText(text);
	}
}