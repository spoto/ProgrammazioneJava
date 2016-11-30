package it.univr.gioco15generalizzato;

public final class TesseraNumerica extends Tessera {
	private final int num;
	
	public TesseraNumerica(int num) {
		this.num = num;
	}

	public int compareTo(Tessera other) {
		if (other instanceof TesseraNumerica)
			return num - ((TesseraNumerica) other).num;
		else
			return 1;
	}

	public boolean equals(Object other) {
		return other instanceof TesseraNumerica
			&& num == ((TesseraNumerica) other).num;
	}

	public String toString() {
		return "" + num;
	}
}
