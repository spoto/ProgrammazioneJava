
public class Even extends Sequence {
	private int n = 0;

	public int next() {
		int result = n;
		n += 2;

		return result;
	}
}
