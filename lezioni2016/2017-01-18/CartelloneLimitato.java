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
		// questa implementazione restituisce un iteratore sugli
		// elementi al momento dell'iterazione con hasNext()/next()
		return new MyIterator();
	}
	
	private class MyIterator implements Iterator<Train> {
		private final Iterator<Train> it = original.iterator();
		private int counter = 0;

		@Override
		public boolean hasNext() {
			return counter < max && it.hasNext();
		}

		@Override
		public Train next() {
			counter++;
			return it.next();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}