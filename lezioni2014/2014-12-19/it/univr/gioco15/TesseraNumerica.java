package it.univr.gioco15;

public final class TesseraNumerica extends Tessera {
	private final int num;
	TesseraNumerica(int num) { this.num = num; }

	@Override
	public boolean equals(Object other) {
		return other instanceof TesseraNumerica
			&& ((TesseraNumerica) other).num == num;
	}

	public String toString() {
		return String.valueOf(num);
	};

	@Override
	public int compareTo(Tessera o) {
		if (o instanceof TesseraNumerica)
			return num - ((TesseraNumerica)o).num;
		else
			throw new IllegalArgumentException();
	}
}