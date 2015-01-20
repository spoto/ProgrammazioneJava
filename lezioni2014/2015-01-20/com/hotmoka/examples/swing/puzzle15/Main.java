package com.hotmoka.examples.swing.puzzle15;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.hotmoka.examples.swing.puzzle15.view.Puzzle15Frame;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new Puzzle15Frame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
