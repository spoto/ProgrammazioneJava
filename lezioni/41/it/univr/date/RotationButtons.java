package it.univr.date;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public abstract class RotationButtons extends javax.swing.JPanel {

	private final JButton up;
	private final JButton down;

	public RotationButtons() {
		setLayout(new GridLayout(2, 1));

		up = new JButton(new ImageIcon("images/arrow_up.png"));
		up.setBorder(BorderFactory.createEmptyBorder());
		up.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				onUpClicked();
			}
		});
		add(up);

		down = new JButton(new ImageIcon("images/arrow_down.png"));
		down.setBorder(BorderFactory.createEmptyBorder());
		down.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				onDownClicked();
			}
		});
		add(down);
	}

	protected abstract void onUpClicked();

	protected abstract void onDownClicked();
}