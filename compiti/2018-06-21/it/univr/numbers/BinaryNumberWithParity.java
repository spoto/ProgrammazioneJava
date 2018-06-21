package it.univr.numbers;

public class BinaryNumberWithParity extends BinaryNumber {
	public BinaryNumberWithParity(int value) {
		super(value);
	}

	@Override
	public String toString() {
		String result = super.toString();
		boolean even = true;
		for (int pos = result.length() - 1; pos >= 0; pos--)
			if (result.charAt(pos) == '1')
				even = !even;

		return result + (even ? '0' : '1');
	}
}