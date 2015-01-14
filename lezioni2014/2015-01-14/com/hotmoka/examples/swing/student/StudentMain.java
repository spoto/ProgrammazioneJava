package com.hotmoka.examples.swing.student;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class StudentMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new StudentFrame();
				frame.setTitle("Database degli Studenti");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
