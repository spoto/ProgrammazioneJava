package com.hotmoka.examples.swing.textcomponents;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class TextComponentsMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new TextComponentFrame();
				frame.setTitle("Text Components Test");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
