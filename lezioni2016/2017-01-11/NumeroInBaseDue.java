
public class NumeroInBaseDue extends NumeroInBase {
	public NumeroInBaseDue(int value) {
		super(value, 2);
	}

	@Override
	public String toString() {
		return Integer.toBinaryString(getValue());
	}
}
