package it.univr.numbers;

public class HexNumber extends AbstractNumber {
	public HexNumber(int value) {
		super(value);
	}

	@Override
	protected int getBase() {
		return 16;
	}

	private final static String digits = "0123456789ABCDEF";

	@Override
	protected char getCharForDigit(int digit) {
		return digits.charAt(digit);
	}
}