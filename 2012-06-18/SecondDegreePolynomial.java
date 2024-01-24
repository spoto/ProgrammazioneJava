// un polinomio del tipo ax^2 + bx + c
public final class SecondDegreePolynomial extends Polynomial {

	public SecondDegreePolynomial(int a, int  b, int c) {
		super(new int[] { a, b, c});

		if (a == 0)
			throw new IllegalArgumentException("first coefficient cannot be 0");
	}

	public boolean canBe0() {
		int[] coefficients = getCoefficients();
		int a = coefficients[0];
		int b = coefficients[1];
		int c = coefficients[2];

		return b * b - 4 * a * c >= 0;
	}
}