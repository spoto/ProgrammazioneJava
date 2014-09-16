package it.univr.tokenizer;

import java.util.Iterator;

public class StringTokenization implements Tokenization {

	private final String s;
	private final String delimiters;

	public StringTokenization(String s, String delimiters) {
		if (delimiters.isEmpty())
			throw new NoDelimitersException();

		this.s = s;
		this.delimiters = delimiters;
	}

	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {

			private String cursor = s;

			@Override
			public boolean hasNext() {
				return !cursor.isEmpty();
			}

			@Override
			public String next() {
				String result = "";
				char nextChar;

				do {
					nextChar = cursor.charAt(0);
					result += nextChar;
					cursor = cursor.substring(1);
				}
				while (!cursor.isEmpty() && delimiters.indexOf(nextChar) == -1);

				return result;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
}