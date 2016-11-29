
public class MainPairs {

	public static void main(String[] args) {
		Pair<String, String> p1
			= new Pair<>("ciao", "amico");

		Pair<String, Sequence> p2
			= new Pair<>("fib", new Fib());

		Pair<String, Integer> p3
			= new Pair<String, Integer>("ciao", 13); // box

		String x = p3.getFirst();
		int y = p3.getSecond(); // unbox
	}

}
