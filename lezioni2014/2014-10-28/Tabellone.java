
public class Tabellone {

	private Display left;
	private Display right;

	public Tabellone(int n) {
		left = new Display(n / 10);
		right = new Display(n % 10);
	}

	public String getRow(int pos) {
		return left.getRow(pos) + ' ' + right.getRow(pos);
	}

	public String toString() {
		String result = "";

		for (int pos = 0; pos < 5; pos++)
			result += getRow(pos) + '\n';

		return result;
	}

	public void next() {
		right.next();
		if (right.getDigit() == 0)
			left.next();
	}
}