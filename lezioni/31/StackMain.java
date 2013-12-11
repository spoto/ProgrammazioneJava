
public class StackMain {

	public static void main(String[] args) {
		Stack s = new ListStack();

		s.push(new Data(13, 1, 1978));
		s.push(new Data(8, 4, 2011));
		s.push(new Data(12, 4, 1979));

		while (!s.isEmpty())
			try {
				System.out.println(s.pop());
			}
			catch (EmptyStackException e) {
				// non succederà mai
			}
	}

}
