
public class ListStack implements Stack {

	private ListOfData list;

	public ListStack() {
		list = null;
	}

	@Override
	public boolean isEmpty() {
		return list == null;
	}

	@Override
	public Data pop() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException();

		Data result = list.getHead();
		list = list.getTail();

		return result;
	}

	@Override
	public void push(Data data) {
		list = new ListOfData(data, list);
	}

	private static class ListOfData {
		private Data head;
		private ListOfData tail;

		private ListOfData(Data head, ListOfData tail) {
			this.head = head;
			this.tail = tail;
		}

		private Data getHead() {
			return head;
		}

		private ListOfData getTail() {
			return tail;
		}
	}
}
