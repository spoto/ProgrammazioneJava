package it.univr.piggy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Piggy extends JButton {

    /**
     * Meglio che l'immagine sia statica, tanto è uguale per tutte le label
     * di questa classe. Così risparmiamo memoria.
     */

    private final static ImageIcon piggy = new ImageIcon("images/piggy.jpg");
    private final static ImageIcon pork = new ImageIcon("images/pork.jpg");

    private final JLabel subtitle;

    public Piggy(JLabel subtitle) {
    	this.subtitle = subtitle;

    	setListener();
    	bePiggy();
    }

	private void bePiggy() {
		setIcon(piggy);
		subtitle.setText("I love being a pig");
	}

	private void bePork() {
		setIcon(pork);
		subtitle.setText("pork is delicious");
	}

	private boolean isPiggy() {
		return getIcon() == piggy;
	}

	private void setListener() {
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (isPiggy())
					bePork();
				else
					bePiggy();
			}
		});
	}
}