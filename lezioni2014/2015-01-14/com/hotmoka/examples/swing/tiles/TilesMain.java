package com.hotmoka.examples.swing.tiles;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class TilesMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new TilesFrame();
				frame.setTitle("Tiles Test");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
