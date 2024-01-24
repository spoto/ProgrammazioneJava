package it.univr.cartellone;

import java.util.Iterator;

public class CartelloneLimitato extends Cartellone {

	private final Cartellone original;
	private final int max;

	public CartelloneLimitato(Cartellone original, int max) {
		this.original = original;
		this.max = max;
	}

	@Override
	public Iterator<Train> iterator() {
		return new Iterator<Train>() {

			private int count;
			private final Iterator<Train> originalIterator = original.iterator();

			@Override
			public boolean hasNext() {
				return count < max && originalIterator.hasNext();
			}

			@Override
			public Train next() {
				count++;
				return originalIterator.next();
			}

			@Override
			public void remove() {} // non usata
		};
	}
}