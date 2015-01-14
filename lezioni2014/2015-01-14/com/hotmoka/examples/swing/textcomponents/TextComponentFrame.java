package com.hotmoka.examples.swing.textcomponents;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextComponentFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	public static final int TEXTAREA_ROWS = 8;
	public static final int TEXTAREA_COLUMNS = 20;

	public TextComponentFrame() {
		JTextField textField = new JTextField();
		JPasswordField passwordField = new JPasswordField();

		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(2, 2));
		northPanel.add(new JLabel("User name: ", JLabel.RIGHT));
		northPanel.add(textField);
		northPanel.add(new JLabel("Password: ", JLabel.RIGHT));
		northPanel.add(passwordField);

		// a frame has by default the border layout
		add(northPanel, BorderLayout.NORTH);

		JTextArea textArea = new JTextArea(TEXTAREA_ROWS, TEXTAREA_COLUMNS);
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		add(scrollPane, BorderLayout.CENTER);

		JPanel southPanel = new JPanel();
		JButton insertButton = new JButton("Insert");
		// a panel has by default the flow layout
		southPanel.add(insertButton);
		insertButton.addActionListener(
			event -> textArea.append("User name: " + textField.getText() +
				" Password: " + new String(passwordField.getPassword()) + "\n"));

		add(southPanel, BorderLayout.SOUTH);

		pack();
	}
}