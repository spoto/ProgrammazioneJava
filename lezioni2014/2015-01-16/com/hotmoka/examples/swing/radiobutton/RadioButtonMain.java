package com.hotmoka.examples.swing.radiobutton;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class RadioButtonMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new RadioButtonFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
