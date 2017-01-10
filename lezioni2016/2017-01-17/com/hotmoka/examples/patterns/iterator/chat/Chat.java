package com.hotmoka.examples.patterns.iterator.chat;

import java.util.Iterator;

public class Chat implements Iterable<Message> {
	private final Message[] messages = new Message[1000];
	private int pos;

	public void addMessage(Message message) {
		if (pos < messages.length)
			messages[pos++] = message;
	}

	@Override
	public Iterator<Message> iterator() {
		return new ChatIterator(messages);
	}
}