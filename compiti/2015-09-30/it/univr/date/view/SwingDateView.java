package it.univr.date.view;

import it.univr.date.controller.Controller;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SwingDateView extends JFrame implements View {
	private final JLabel hours = new JLabel();
	private final JLabel minutes = new JLabel();
	private final JLabel seconds = new JLabel();

	public SwingDateView(Controller controller) {
		super("Time");

		setMinimumSize(new Dimension(200, 120));

		add(buildClockPanel(controller), BorderLayout.CENTER);

		pack();
		setVisible(true);
	}

	protected JPanel buildClockPanel(Controller controller) {
		JPanel clock = new JPanel();

		JPanel hoursPanel = new JPanel();
		hoursPanel.setLayout(new BorderLayout());
		JButton increaseHours = new JButton("+");
		hoursPanel.add(increaseHours, BorderLayout.NORTH);
		hoursPanel.add(hours, BorderLayout.CENTER);
		JButton decreaseHours = new JButton("-");
		hoursPanel.add(decreaseHours, BorderLayout.SOUTH);
		clock.add(hoursPanel);

		JPanel minutesPanel = new JPanel();
		minutesPanel.setLayout(new BorderLayout());
		JButton increaseMinutes = new JButton("+");
		minutesPanel.add(increaseMinutes, BorderLayout.NORTH);
		minutesPanel.add(minutes, BorderLayout.CENTER);
		JButton decreaseMinutes = new JButton("-");
		minutesPanel.add(decreaseMinutes, BorderLayout.SOUTH);
		clock.add(minutesPanel);

		JPanel secondsPanel = new JPanel();
		secondsPanel.setLayout(new BorderLayout());
		JButton increaseSeconds = new JButton("+");
		secondsPanel.add(increaseSeconds, BorderLayout.NORTH);
		secondsPanel.add(seconds, BorderLayout.CENTER);
		JButton decreaseSeconds = new JButton("-");
		secondsPanel.add(decreaseSeconds, BorderLayout.SOUTH);
		clock.add(secondsPanel);

		increaseHours.addActionListener(e -> controller.onIncreaseHours());
		decreaseHours.addActionListener(e -> controller.onDecreaseHours());
		increaseMinutes.addActionListener(e -> controller.onIncreaseMinutes());
		decreaseMinutes.addActionListener(e -> controller.onDecreaseMinutes());
		increaseSeconds.addActionListener(e -> controller.onIncreaseSeconds());
		decreaseSeconds.addActionListener(e -> controller.onDecreaseSeconds());

		return clock;
	}

	@Override
	public void onTimeChanged(int hours, int minutes, int seconds) {
		this.hours.setText(String.valueOf(hours));
		this.minutes.setText(String.format("%02d", minutes));
		this.seconds.setText(String.format("%02d", seconds));
	}
}