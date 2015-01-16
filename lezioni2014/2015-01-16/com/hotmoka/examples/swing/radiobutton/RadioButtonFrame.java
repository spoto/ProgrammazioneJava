package com.hotmoka.examples.swing.radiobutton;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButtonFrame extends JFrame {

	private final JLabel label;
	private final JPanel buttonPanel;
	private final ButtonGroup group;
	private static final int DEFAULT_SIZE = 12;

    public RadioButtonFrame() {
		setTitle("RadioButton Test");

		label = new JLabel("The quick brown fox jumps over the lazy dog.");
		label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
		add(label, BorderLayout.CENTER);

		buttonPanel = new JPanel();
		group = new ButtonGroup();

		addRadioButton("Small", 8);
		addRadioButton("Medium", 12);
		addRadioButton("Large", 18);
		addRadioButton("Extra large", 36);

		add(buttonPanel, BorderLayout.SOUTH);

		pack();
    }

	private void addRadioButton(String name, int size) {
		boolean selected = size == DEFAULT_SIZE;
		JRadioButton button = new JRadioButton(name, selected);
		button.addActionListener
			(event -> {
				label.setFont(new Font("Serif", Font.PLAIN, size));
				pack();
			});

		group.add(button);
		buttonPanel.add(button);
	}

	private static final long serialVersionUID = 1L;
}








