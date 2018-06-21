package it.univr.numbers;

public class DecimalNumber extends AbstractNumber {
	public DecimalNumber(int value) {
		super(value);
	}

	@Override
	protected int getBase() {
		return 10;
	}

	@Override
	protected char getCharForDigit(int digit) {
		return (char) ('0' + digit);
	}
}