
public class Fib extends Sequence {
	private int n1 = 1;
	private int n2 = 1;

	public int next() {
		int result = n1;
		int temp = n2;
		n2 += n1;
		n1 = temp;

		return result;
	}
}
