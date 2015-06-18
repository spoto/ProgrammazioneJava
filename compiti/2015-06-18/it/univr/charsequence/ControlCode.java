package it.univr.charsequence;

public class ControlCode extends AbstractCharSequence {

	private final CharSequence original;

	public ControlCode(CharSequence original) {
		this.original = original;
	}

	@Override
	public int length() {
		return original.length() + 1;
	}

	@Override
	public char charAt(int index) {
		if (index == original.length())
			return code();
		else
			return original.charAt(index);
	}

	private char code() {
		int sum = 0;
		for (int index = 0; index < original.length(); index++)
			sum += charAt(index);

		return (char) ('a' + sum % 26);
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		if (start < 0 || end < 0 || start > end || end > length())
			throw new IndexOutOfBoundsException();

		String result = "";
		for (int index = start; index < end; index++)
			result += charAt(index);

		return result;
	}
}