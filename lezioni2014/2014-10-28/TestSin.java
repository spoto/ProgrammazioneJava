
public class TestSin {

	public static void main(String[] args) {
		double v = 0.0;
		for (int i = 1; i <= 1000; i++) {
			stampaSpazi((int) ((Math.sin(v) + 1) * 60)); // tra 0 e 78
			System.out.println("*\n");
			v += 0.1;
		}

	}

	private static void stampaSpazi(int num) {
		while (num-- > 0)
			System.out.print(' ');
	}

}
