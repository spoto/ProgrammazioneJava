
public abstract class NumeroInBase extends AbstractNumero {
	private final int base;

	protected NumeroInBase(int value, int base) {
		super(value);

		this.base = base;
	}
	
	public int getBase() {
		return base;
	}
}
