package com.hotmoka.examples.swing.helloWorld;

import javax.swing.JFrame;

public class HelloWorldFrame extends JFrame {

	public HelloWorldFrame() {
		add(new HelloWorldComponent());
		pack();
	}

	private static final long serialVersionUID = 1L;
}
