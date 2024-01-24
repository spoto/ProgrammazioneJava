package it.univr.numbers;

public abstract class AbstractNumber implements Number {
	private final int value;

	protected AbstractNumber(int value) {
		if (value < 0)
			throw new IllegalArgumentException("negative numbers are not allowed");

		this.value = value;
	}

	@Override
	public final int getValue() {
		return value;
	}

	protected abstract int getBase();

	protected abstract char getCharForDigit(int digit);

	@Override
	public String toString() {
		String result = "";

		int v = value, base = getBase();
		do {
			result = getCharForDigit(v % base) + result;
			v /= base;
		}
		while (v > 0);

		return result;
	}

	@Override
	public final boolean equals(Object other) {
		return other instanceof Number && ((Number) other).getValue() == value;
	}

	@Override
	public final int hashCode() {
		return value;
	}
}