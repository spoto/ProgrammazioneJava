package com.hotmoka.examples.patterns.iterator.chat;

import java.util.Iterator;

public class ChatIterator implements Iterator<Message> {
	private final Message[] messages;
	private int cursor;

	public ChatIterator(Message[] messages) {
		this.messages = messages;
	}

	@Override
	public boolean hasNext() {
		return cursor < messages.length && messages[cursor] != null;
	}

	@Override
	public Message next() {
		return messages[cursor++];
	}
}

