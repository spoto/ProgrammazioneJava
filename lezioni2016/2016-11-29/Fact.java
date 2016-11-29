
public class Fact extends Sequence {
	private int counter = 0;
	private int n = 1;

	public int next() {
		int result = n;
		n *= ++counter;

		return result;
	}

}
