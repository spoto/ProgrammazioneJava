package it.univr.date;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Booking extends JFrame {

	private DatePicker leave;
	private DatePicker back;

	public Booking() {
		super("booking");

		setSize(800, 500);
		setLayout(new GridLayout(2, 1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel pickers = createPickersPanel();
		JPanel book = createBookingPanel();

		add(pickers);
		add(book);
	}

	private JPanel createPickersPanel() {
		JPanel panel = new JPanel();
	
		panel.setLayout(new FlowLayout());
	
		panel.add(leave = new DatePicker("Leaving on"));
		panel.add(back = new DatePicker("Returning on"));
	
		return panel;
	}

	private JPanel createBookingPanel() {
		JPanel panel = new JPanel();

		panel.setLayout(new GridLayout(2, 1));

		final JLabel message = new JLabel();

		final JButton book = new JButton("Book now");
		book.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				message.setText("leaving on " + leave.getDate() + " and coming back on " + back.getDate());
			}
		});

		panel.add(new JPanel() {{
			add(book);
		}});

		panel.add(new JPanel() {{
			add(message);
		}});

		return panel;
	}

	public static void main(String[] args) {
		new Booking().setVisible(true);
	}
}
