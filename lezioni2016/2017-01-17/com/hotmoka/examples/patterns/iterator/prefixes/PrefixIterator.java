package com.hotmoka.examples.patterns.iterator.prefixes;

import java.util.Iterator;

public class PrefixIterator implements Iterator<String> {
	private String s;

	public PrefixIterator(String sentence) {
		this.s = sentence;
	}

	@Override
	public boolean hasNext() {
		return s != null;
	}

	@Override
	public String next() {
		String result = s;
		if (s.isEmpty())
			s = null;
		else
			s = s.substring(0, s.length() - 1);

		return result;
	}
}

