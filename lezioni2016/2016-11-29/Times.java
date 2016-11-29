
public class Times extends Sequence {
	private final int multiplier;
	private final Sequence base;

	public Times(Sequence base, int multiplier) {
		this.base = base;
		this.multiplier = multiplier;
	}

	public int next() {
		return multiplier * base.next();
	}
}