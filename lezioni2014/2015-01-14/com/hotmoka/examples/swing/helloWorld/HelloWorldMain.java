package com.hotmoka.examples.swing.helloWorld;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class HelloWorldMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new HelloWorldFrame();
				frame.setTitle("Hello World");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
