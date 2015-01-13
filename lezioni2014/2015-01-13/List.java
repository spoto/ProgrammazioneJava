import java.util.ArrayList;


public class List {

	private Node start;
	
	public List() {
	}

	public List(int v) {
		start = new Node(v, null);
	}

	public List(ArrayList<Integer> values) {
		for (int pos = 0; pos < values.size(); pos++)
			start = new Node(values.get(pos), start);
	}

	public int getFirst() {
		return start.head;
	}

	public void removeFirst() {
		start = start.tail;
	}

	public int length() {
		return start == null ? 0 : start.length();
	}

	private static class Node {
		private final int head;
		private final Node tail;
		
		private Node(int head, Node tail) {
			this.head = head;
			this.tail = tail;
		}

		private int length() {
			if (tail == null)
				return 1;
			else
				return 1 + tail.length();
		}
	}
}
