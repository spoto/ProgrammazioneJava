package it.univr.date;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class Picker extends JPanel {

	private JTextField field;

	public Picker(String name, int initialValue, int charCount) {
		setLayout(new FlowLayout());

		add(new JLabel(name));
		field = new JTextField(String.valueOf(initialValue), charCount);
		add(field);
		add(new RotationButtons() {

			@Override
			protected void onUpClicked() {
				Picker.this.onUpClicked();
			}

			@Override
			protected void onDownClicked() {
				Picker.this.onDownClicked();
			}
		});
	}

	public int getValue() {
		try {
			return Integer.parseInt(field.getText());
		}
		catch (NumberFormatException e) {
			field.setText("1");
			return 1;
		}
	}

	public void setValue(int value) {
		field.setText(String.valueOf(value));
	}

	protected abstract void onUpClicked();
	protected abstract void onDownClicked();
}