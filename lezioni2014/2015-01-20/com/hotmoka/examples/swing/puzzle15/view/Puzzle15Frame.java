package com.hotmoka.examples.swing.puzzle15.view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.hotmoka.examples.swing.puzzle15.controller.Controller;
import com.hotmoka.examples.swing.puzzle15.controller.Puzzle15Controller;
import com.hotmoka.examples.swing.puzzle15.model.LongBackedConfiguration;
import com.hotmoka.examples.swing.puzzle15.model.TilesModel;

public class Puzzle15Frame extends JFrame {
	private final TilesModel model = new TilesModel(new LongBackedConfiguration());
	private final Controller controller;

	public Puzzle15Frame() {
		setTitle("Puzzle 15");

		View view = addTiles();
		controller = new Puzzle15Controller(view);
		controller.randomize();
		addControlButtons();

		setIconImage(new ImageIcon("img/puzzle15.jpg").getImage());

		pack();
	}

	private void addControlButtons() {
		JPanel panel = new JPanel();

		JButton randomize = new JButton("Randomize");
		randomize.addActionListener(event -> controller.randomize());
		panel.add(randomize);

		JButton hint = new JButton("Hint");
		hint.addActionListener(event -> controller.giveHint());
		panel.add(hint);

		add(panel, BorderLayout.NORTH);
	}

	private View addTiles() {
		TilesPanel panel = new TilesPanel(model, this);
		add(panel, BorderLayout.CENTER);

		return panel;
	}

	private static final long serialVersionUID = 1L;
}