package it.univr.components;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class OutputWindow extends JFrame {
	public OutputWindow(String message) {
		super("output");

		setSize(200, 100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout());
		add(new JLabel(message));
	}
}
