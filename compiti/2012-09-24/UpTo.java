import java.util.Iterator;

// i numeri interi da una costante in poi
public class UpTo extends Numbers {

	private final int max;
	private final Numbers base;

	public UpTo(int max, Numbers base) {
		this.max = max;
		this.base = base;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {

			private final Iterator<Integer> baseIterator = base.iterator();
			private Integer next = findNext();

			@Override
			public boolean hasNext() {
				return next != null;
			}

			private Integer findNext() {
				if (baseIterator.hasNext()) {
					Integer next = baseIterator.next();
					if (next <= max)
						return next;
				}

				return null;
			}

			@Override
			public Integer next() {
				Integer result = next;
				next = findNext();
				return result;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
			
		};
	}

}
