
public class List {
	private int value;
	private List tail;

	public List(int value, List tail) {
		this.value = value;
		this.tail = tail;
	}

	public String toString() {
		if (tail == null)
			return "" + value;
		else
			return value + " " + tail.toString();
	}

	public int length() {
		if (tail == null)
			return 1;
		else
			return 1 + tail.length();
	}

	public int last() {
		if (tail == null)
			return value;
		else
			return tail.last();
	}

	public boolean equals(List other) {
		if (other == null)
			return false;
		else if (this.value != other.value)
			return false;
		else if (tail != null)
			return tail.equals(other.tail);
		else
			return other.tail == null;
	}
}
