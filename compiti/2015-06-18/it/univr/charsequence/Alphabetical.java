package it.univr.charsequence;

public class Alphabetical extends AbstractCharSequence {

	private final char start;
	private final int length;

	public Alphabetical(char start, int length) {
		if (start < 'a' || start > 'z')
			throw new IllegalArgumentException("alphabetical character required. Got " + start);
		if (length < 0)
			throw new IndexOutOfBoundsException("sequence cannot have negative length. Got " + length);

		this.start = start;
		this.length = length;
	}

	@Override
	public int length() {
		return length;
	}

	@Override
	public char charAt(int index) {
		if (index < 0 || index >= length)
			throw new IndexOutOfBoundsException("index must be between 0 and " + (length - 1) + ". Got " + index);

		return (char) ('a' + (start -'a' + index) % 26);
	}

	@Override
	public Alphabetical subSequence(int start, int end) {
		if (start < 0 || end < 0 || start > end || end > length)
			throw new IndexOutOfBoundsException();

		return new Alphabetical(charAt(start), end - start);
	}
}