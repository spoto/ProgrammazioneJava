
public class ModifiableArraySet extends ArraySet implements ModifiableSet {

	public ModifiableArraySet() {
		super();
	}

	public ModifiableArraySet(Object... elements) {
		super(elements);
	}

	public ModifiableArraySet(Set father) {
		for (Object element: father)
			add(element);
	}

	@Override
	public boolean add(Object element) {
		if (contains(element))
			return false;

		Object[] newElements = new Object[size() + 1];
		int pos = 0;
		for (Object e: this)
			newElements[pos++] = e;
		newElements[pos] = element;

		setElements(newElements);

		return true;
	}

	@Override
	public boolean remove(Object element) {
		if (!contains(element))
			return false;

		Object[] newElements = new Object[size() - 1];
		int pos = 0;
		for (Object e: this)
			if (!e.equals(element))
				newElements[pos++] = e;

		setElements(newElements);

		return true;
	}

	@Override
	public boolean addAll(Set set) {
		boolean added = false;

		for (Object element: set)
			added |= add(element);

		return added;
	}

	@Override
	public boolean removeAll(Set set) {
		boolean removed = false;

		for (Object element: set)
			removed |= remove(element);

		return removed;
	}

}