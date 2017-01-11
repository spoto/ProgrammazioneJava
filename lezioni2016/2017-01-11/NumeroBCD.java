
public class NumeroBCD extends AbstractNumero {
	public NumeroBCD(int value) {
		super(value);
		
		if (value < 0)
			throw new IllegalArgumentException();
	}

	@Override
	public String toString() {
		String result = "";
		int value = getValue();
		do {
			result = digit(value % 10) + result;
			value /= 10;
		}
		while (value > 0);

		return result;
	}

	private String digit(int digit) {
		switch (digit) {
		case 0: return "0000";
		case 1: return "0001";
		case 2: return "0010";
		case 3: return "0011";
		case 4: return "0100";
		case 5: return "0101";
		case 6: return "0110";
		case 7: return "0111";
		case 8: return "1000";
		default: return "1001";
		}
	}
}
