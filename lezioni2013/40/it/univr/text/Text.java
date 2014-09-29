package it.univr.text;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Text extends JFrame {
	private JLabel testo1;
	private JLabel testo2;

	public Text() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		testo1 = new JLabel();
		testo2 = new JLabel();

		final JTextField field1 = new JTextField(20);
		add(field1);
		field1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				testo1.setText(field1.getText());
			}
			
		});

		final JTextField field2 = new JTextField(40);
		add(field2);
		field2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				testo2.setText(field2.getText());
			}
			
		});

		add(testo1);
		add(testo2);

	}

	public static void main(String[] args) {
		new Text().setVisible(true);
	}
}
