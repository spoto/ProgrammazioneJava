package com.hotmoka.examples.swing.puzzle15.ai;

import com.hotmoka.examples.swing.puzzle15.model.Configuration;

public class Steps {
	public final Configuration head;
	public final Steps tail;
	
	public Steps(Configuration head, Steps tail) {
		this.head = head;
		this.tail = tail;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (Steps cursor = this; cursor != null; cursor = cursor.tail)
			sb.insert(0, cursor.head + "\n");

		return sb.toString();
	}

	public int length() {
		if (tail == null)
			return 1;
		else
			return 1 + tail.length();
	}
}