package it.univr.numbers;

public class Base58Number extends AbstractNumber {
	public Base58Number(int value) {
		super(value);
	}

	@Override
	protected int getBase() {
		return 58;
	}

	private final static String digits = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";

	@Override
	protected char getCharForDigit(int digit) {
		return digits.charAt(digit);
	}
}