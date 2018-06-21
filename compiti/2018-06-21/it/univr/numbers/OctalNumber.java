package it.univr.numbers;

public class OctalNumber extends AbstractNumber {
	public OctalNumber(int value) {
		super(value);
	}

	@Override
	protected int getBase() {
		return 8;
	}

	@Override
	protected char getCharForDigit(int digit) {
		return (char) ('0' + digit);
	}
}