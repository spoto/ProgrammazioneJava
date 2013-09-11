
public class Main {

	public static void main(String[] args) {
		Numbers from8To25 = new UpTo(25, new From(8));
		System.out.println(from8To25);
		Numbers from100To120 = new UpTo(120, new From(100));
		System.out.println(from100To120);
		Numbers concat = new Concat(from8To25, from100To120);
		System.out.println(concat);
		Numbers alternate = new Alternate(from8To25, from100To120);
		System.out.println(alternate);
		System.out.println(new UpTo(100, alternate));
	}

}
