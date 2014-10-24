
public class Main {
	public static void main(String[] args) {
		Display d = new Display(0);

		for (int num = 0; num < 10; num++) {
			System.out.println(d);
			d.next();
		}
	}
}