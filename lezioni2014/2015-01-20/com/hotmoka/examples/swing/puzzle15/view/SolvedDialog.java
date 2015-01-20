package com.hotmoka.examples.swing.puzzle15.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.hotmoka.examples.swing.puzzle15.controller.Controller;

public class SolvedDialog extends JDialog {

	public SolvedDialog(JFrame owner, Controller controller) {
		super(owner, "Game Solved", true);

		add(new JLabel("<html><h1>Game Solved!</h1></html>"));

		JButton ok = new JButton("OK");
		ok.addActionListener(event -> {
			controller.randomize();
			setVisible(false);
		});

		JPanel panel = new JPanel();
		panel.add(ok);
		add(panel, BorderLayout.SOUTH);

		pack();
	}

	private static final long serialVersionUID = 1L;
}