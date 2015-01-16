package com.hotmoka.examples.swing.checkbox;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CheckBoxFrame extends JFrame {

	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;

	private final JLabel label;
	private JCheckBox bold;
	private JCheckBox italic;
	private static final int FONTSIZE = 12;

    public CheckBoxFrame() {
		setTitle("CheckBox Test");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		label = new JLabel("The quick brown fox jumps over the lazy dog.");
		label.setFont(new Font("Serif", Font.PLAIN, FONTSIZE));
		add(label, BorderLayout.CENTER);

		ActionListener listener = event ->
		{
			int mode = Font.PLAIN;
			if (bold.isSelected()) mode |= Font.BOLD;
			if (italic.isSelected()) mode |= Font.ITALIC;
			label.setFont(new Font("Serif", mode, FONTSIZE));
		};

		JPanel buttonPanel = new JPanel();
		bold = new JCheckBox("Bold");
		bold.addActionListener(listener);
		buttonPanel.add(bold);

		italic = new JCheckBox("Italic");
		italic.addActionListener(listener);
		buttonPanel.add(italic);

		add(buttonPanel, BorderLayout.SOUTH);
    }

	private static final long serialVersionUID = 1L;
}