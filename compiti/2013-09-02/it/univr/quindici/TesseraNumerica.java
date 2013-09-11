package it.univr.quindici;

public final class TesseraNumerica extends Tessera {

	private final int num;

	TesseraNumerica(int num) {
		this.num = num;
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof TesseraNumerica && ((TesseraNumerica) other).num == num;
	}

	@Override
	public int hashCode() {
		return num;
	}

	@Override
	public String toString() {
		return String.valueOf(num);
	}

	@Override
	public int compareTo(Tessera o) {
		return num - ((TesseraNumerica) o).num;
	}
}