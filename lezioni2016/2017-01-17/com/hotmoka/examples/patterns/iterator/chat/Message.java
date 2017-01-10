package com.hotmoka.examples.patterns.iterator.chat;

public class Message {
	private final String author;
	private final String message;

	public Message(String author, String message) {
		this.author = author;
		this.message = message;
	}

	@Override
	public String toString() {
		return author + " says: \"" + message + "\"";
	}
}


