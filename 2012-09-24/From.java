import java.util.Iterator;

// i numeri interi da una costante in poi
public class From extends Numbers {

	private final int start;

	public From(int start) {
		this.start = start;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {

			private int next = start;

			@Override
			public boolean hasNext() {
				return true;
			}

			@Override
			public Integer next() {
				return next++;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
			
		};
	}

}
