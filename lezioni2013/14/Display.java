
public class Display {
	private static String[][] rows = {
		{"***", " * ", "***", "***", "*  ", "***", "***", "***", "***", "***"},
		{"* *", " * ", "  *", "  *", "*  ", "*  ", "*  ", "  *", "* *", "* *"},
		{"* *", " * ", "***", "***", "* *", "***", "***", " **", "***", "***"},
		{"* *", " * ", "*  ", "  *", "***", "  *", "* *", "  *", "* *", "  *"},
		{"***", " * ", "***", "***", "  *", "***", "***", "  *", "***", "***"}
	};

	private int digit;

	public Display(int digit) {
		this.digit = digit;
	}

	public int getDigit() {
		return digit;
	}

	public String getRow(int i) {
		return rows[i][digit];
	}

	public String toString() {
		return getRow(0) + '\n' +
			getRow(1) + '\n' +
			getRow(2) + '\n' +
			getRow(3) + '\n' +
			getRow(4) + '\n';
	}

	public void next() {
		digit = (digit + 1) % 10;
	}

	public boolean equals(Display other) {
		return this.digit == other.digit;
	}
}