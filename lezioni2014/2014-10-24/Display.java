
public class Display {

	private int digit;
	
	public Display(int digit) {
		this.digit = digit;
	}
	
	public int getDigit() {
		return digit;
	}

	private static String[] zero = {
			"***",
			"* *",
			"* *",
			"* *",
			"***"
	};

	private static String[] uno = {
			" * ",
			" * ",
			" * ",
			" * ",
			" * "
	};

	private static String[] due = {
			"***",
			"  *",
			"***",
			"*  ",
			"***"
	};

	private static String[] tre = {
		"***",
		"  *",
		"***",
		"  *",
		"***"
	};

	private static String[] quattro = {
		"* *",
		"* *",
		"***",
		"  *",
		"  *"
	};

	private static String[] cinque = {
		"***",
		"*  ",
		"***",
		"  *",
		"***"
	};

	private static String[] sei = {
		"***",
		"*  ",
		"***",
		"* *",
		"***"
	};

	private static String[] sette = {
		"***",
		"  *",
		" **",
		" * ",
		" * "
	};

	private static String[] otto = {
		"***",
		"* *",
		"***",
		"* *",
		"***"
	};

	private static String[] nove = {
		"***",
		"* *",
		"***",
		"  *",
		"***"
	};

	public String getRow(int i) {
		switch (digit) {
		case 0:
			return zero[i];
		case 1:
			return uno[i];
		case 2:
			return due[i];
		case 3:
			return tre[i];
		case 4:
			return quattro[i];
		case 5:
			return cinque[i];
		case 6:
			return sei[i];
		case 7:
			return sette[i];
		case 8:
			return otto[i];
		case 9:
			return nove[i];
		default:
			return "";
		}
	}
	
	public String toString() {
		return getRow(0) + "\n"
				+ getRow(1) + "\n"
				+ getRow(2) + "\n"
				+ getRow(3) + "\n"
				+ getRow(4) + "\n";
	}
	
	public void next() {
		digit++;
		digit %= 10;
	}
	
	public boolean equals(Display other) {
		return this.digit == other.digit;
	}
}