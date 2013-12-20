package it.univr.gioco15;

public class TesseraNumerica extends Tessera {

	private final int num;

	public TesseraNumerica(int num) {
		this.num = num;
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof TesseraNumerica &&
			((TesseraNumerica) other).num == num;
	}

	@Override
	public String toString() {
		return String.valueOf(num);
	}

	@Override
	public int compareTo(Tessera other) {
		if (other instanceof TesseraNumerica)
			return num - ((TesseraNumerica) other).num;
		else
			return this.getClass().getName().compareTo(other.getClass().getName());
	}
}
