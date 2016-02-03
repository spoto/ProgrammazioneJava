package it.univr.elezioni;

public class ElezioniIstogramma extends Elezioni {

	@Override
	public String toString() {
		String result = super.toString() + "\n";
		int numeroVotiEspressi = numeroVotiEspressi();

		int num = 1;
		for (Partito partito: Partito.elementi())
			result += ripeti(num++, votiPer(partito) * 50 / numeroVotiEspressi);

		result += "\n";

		return result;
	}

	private String ripeti(int num, int numeroRipetizioni) {
		String res = "";
		while (numeroRipetizioni-- > 0)
			res += num;

		return res;
	}
}