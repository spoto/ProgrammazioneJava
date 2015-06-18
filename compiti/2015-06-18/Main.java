import it.univr.charsequence.Alphabetical;
import it.univr.charsequence.ControlCode;

public class Main {

	private static int counter;

	public static void main(String[] args) {
		CharSequence a1 = new Alphabetical('c', 26);
		CharSequence a2 = new Alphabetical('h', 60);
		CharSequence a3 = a2.subSequence(5, 40);
		print(a1);  // 1
		print(a2);  // 2
		print(a3);  // 3

		CharSequence c1 = new ControlCode("Shakespeare");
		CharSequence c2 = new ControlCode(a3);
		print(c1);  // 4
		print(c2);  // 5

		CharSequence s1 = "There is no world without Verona walls";
		CharSequence s2 = "But purgatory, torture, hell itself";
		print(s1);  // 6
		print(s2);  // 7

		CharSequence app = s1.toString() + a2.toString();
		print(app); // 8

		CharSequence last = c2.subSequence(35, 36);
		print(last);// 9
	}

	private static void print(CharSequence seq) {
		System.out.println(++counter + ": " + seq + " length = " + seq.length());
	}
}