public interface Set extends Iterable<Object> {
	boolean contains(Object element);
	boolean intersects(Set other);
	int size();
}