package it.univr.charsequence;

public abstract class AbstractCharSequence implements CharSequence {

	@Override
	public final String toString() {
		String result = "";
		for (int index = 0; index < length(); index++)
			result += charAt(index);

		return result;
	}
}