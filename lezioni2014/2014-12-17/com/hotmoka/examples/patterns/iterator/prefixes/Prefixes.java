package com.hotmoka.examples.patterns.iterator.prefixes;

import java.util.Iterator;

public class Prefixes implements Iterable<String> {
	private final String sentence;

	public Prefixes(String sentence) {
		this.sentence = sentence;
	}

	@Override
	public Iterator<String> iterator() {
		return new PrefixIterator(sentence);
	}
}



