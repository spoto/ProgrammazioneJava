public interface ModifiableSet extends Set {
	boolean add(Object element);
	boolean remove(Object element);
	boolean addAll(Set set);
	boolean removeAll(Set set);
}