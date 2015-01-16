package com.hotmoka.examples.swing.checkbox;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class CheckBoxMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new CheckBoxFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
