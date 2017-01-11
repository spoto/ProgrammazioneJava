
public class NumeroInBaseSedici extends NumeroInBase {
	public NumeroInBaseSedici(int value) {
		super(value, 16);
	}

	@Override
	public String toString() {
		return Integer.toHexString(getValue());
	}
}
