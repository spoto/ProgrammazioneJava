package it.univr.date.view;

import it.univr.date.controller.Controller;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Swing12DateView extends SwingDateView {

	private JLabel ampm;

	public Swing12DateView(Controller controller) {
		super(controller);
	}

	@Override
	protected JPanel buildClockPanel(Controller controller) {
		JPanel clock = super.buildClockPanel(controller);
		ampm = new JLabel();
		clock.add(ampm);

		return clock;
	}

	@Override
	public void onTimeChanged(int hours, int minutes, int seconds) {
		super.onTimeChanged(hours % 12 == 0 ? 12 : hours % 12, minutes, seconds);
		
		ampm.setText(hours < 12 ? "am" : "pm");
	}
}