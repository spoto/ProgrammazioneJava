package it.univr.tokenizer;

import java.util.Iterator;

public class DoubleTokenization implements Tokenization {

	private final Tokenization base;
	private final String delimiters;

	public DoubleTokenization(Tokenization base, String delimiters) {
		this.base = base;
		this.delimiters = delimiters;
	}

	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {

			private final Iterator<String> baseIterator = base.iterator();
			private Iterator<String> secondIterator;

			@Override
			public boolean hasNext() {
				return baseIterator.hasNext() || (secondIterator != null && secondIterator.hasNext());
			}

			@Override
			public String next() {
				if (secondIterator != null && secondIterator.hasNext())
					return secondIterator.next();

				this.secondIterator = new StringTokenization(baseIterator.next(), delimiters).iterator();

				return next();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
}