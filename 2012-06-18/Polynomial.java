public class Polynomial {
	// i coefficienti del polinomio. Può essere vuoto. Se non è vuoto,
	// il primo elemento non è mai 0
	private final int[] coefficients;

	public Polynomial(int[] coefficients) {
		// calcoliamo quanti coefficienti all'inizio dell'array sono 0
		int unused = 0;
		while (unused < coefficients.length && coefficients[unused] == 0)
			unused++;

		// copiamo solo la porzione non 0 dei coefficienti
		this.coefficients = new int[coefficients.length - unused];
		for (int pos = unused; pos < coefficients.length; pos++)
			this.coefficients[pos - unused] = coefficients[pos];
	}

	protected final int[] getCoefficients() {
		return coefficients;
	}

	public final int degree() {
		return coefficients.length - 1;
	}

	public final Polynomial add(Polynomial other) {
		// size coefficienti sono sufficienti per il risultato
		int size = Math.max(degree(), other.degree()) + 1;

		int[] coefficients = new int[size];

		for (int pos = degree(), i = size - 1; pos >= 0; pos--, i--)
			coefficients[i] = this.coefficients[pos];

		for (int pos = other.degree(), i = size - 1; pos >= 0; pos--, i--)
			coefficients[i] += other.coefficients[pos];

		// il costruttore eliminerà eventuali coefficienti 0 iniziali
		return new Polynomial(coefficients);
	}

	public final int evaluate(int x) {
		int value = 0;

		for (int pos = 0; pos < coefficients.length; pos++) {
			value = value * x;
			value += coefficients[pos];
		}

		return value;
	}

	@Override
	public final String toString() {
		String result = "";

		int exponent = coefficients.length - 1;
		for (int pos = 0; exponent >= 0; pos++, exponent--)
			if (coefficients[pos] > 0)
				result += " + " + coefficients[pos] + "x^" + exponent;
			else if (coefficients[pos] < 0)
				result += " - " + -coefficients[pos] + "x^" + exponent;

		return result;
	}

	@Override
	public final boolean equals(Object other) {
		if (!(other instanceof Polynomial))
			return false;
		else {
			Polynomial otherP = (Polynomial) other;
			if (coefficients.length != otherP.coefficients.length)
				return false;
			for (int pos = 0; pos < coefficients.length; pos++)
				if (coefficients[pos] != otherP.coefficients[pos])
					return false;

			return true;
		}
	}

	@Override
	public final int hashCode() {
		// un hashcode veloce da calcolare: la somma dei coefficienti
		int hashCode = 0;
		for (int pos = 0; pos < coefficients.length; pos++)
			hashCode += coefficients[pos];

		return hashCode;
	}
}