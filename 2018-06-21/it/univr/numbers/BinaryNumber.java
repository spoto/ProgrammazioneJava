package it.univr.numbers;

public class BinaryNumber extends AbstractNumber {
	public BinaryNumber(int value) {
		super(value);
	}

	@Override
	protected int getBase() {
		return 2;
	}

	@Override
	protected char getCharForDigit(int digit) {
		return digit == 0 ? '0' : '1';
	}
}