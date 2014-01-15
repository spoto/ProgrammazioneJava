package it.univr.components;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class AbstractCampoInserimento extends JPanel {
	private final JTextField right;

	public AbstractCampoInserimento(String label, int charCount) {
		setLayout(new FlowLayout());

		JLabel left = new JLabel(label);
		add(left);

		right = new JTextField(charCount);
		add(right);
	}
	
	protected JTextField getTextField() {
		return right;
	}
}
