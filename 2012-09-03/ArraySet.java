import java.util.Iterator;


public class ArraySet implements Set {

	private Object[] elements;

	public ArraySet(Object... elements) {
		this.elements = new Object[0];
		// aggiungiamo gli elementi, ma evitando le ripetizioni
		for (Object e: elements)
			if (!contains(e)) {
				Object[] newElements = new Object[this.elements.length + 1];
				for (int pos = 0; pos < this.elements.length; pos++)
					newElements[pos] = this.elements[pos];
				newElements[this.elements.length] = e;
				this.elements = newElements;
			}
	}

	protected Object[] getElements() {
		return elements;
	}

	protected void setElements(Object[] elements) {
		this.elements = elements;
	}

	@Override
	public boolean contains(Object element) {
		for (Object e: elements)
			if (e.equals(element))
				return true;

		return false;
	}

	@Override
	public boolean intersects(Set other) {
		for (Object e: elements)
			if (other.contains(e))
				return true;

		return false;
	}

	@Override
	public int size() {
		return elements.length;
	}

	@Override
	public Iterator<Object> iterator() {
		return new Iterator<Object>() {

			private int pos; // = 0;

			@Override
			public boolean hasNext() {
				return pos < size();
			}

			@Override
			public Object next() {
				return elements[pos++];
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
			
		};
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Set))
			return false;

		Set otherSet = (Set) other;
		if (size() != otherSet.size())
			return false;

		for (Object element: this)
			if (!otherSet.contains(element))
				return false;

		return true;
	}

	@Override
	public int hashCode() {
		int code = 0;
		for (Object element: this)
			// or esclusivo, ma ogni altra funzione va bene
			code ^= element.hashCode();

		return code;
	}
}