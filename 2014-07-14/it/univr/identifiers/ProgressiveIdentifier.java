package it.univr.identifiers;

public class ProgressiveIdentifier implements Identifier {

	private final Identifier base;
	private final int num;

	public ProgressiveIdentifier(Identifier base, int num) throws NegativeProgressiveNumberException {
		if (num < 0)
			throw new NegativeProgressiveNumberException(num);

		this.base = base;
		this.num = num;
	}

	@Override
	public String toString() {
		return base + "_" + num;
	}
}