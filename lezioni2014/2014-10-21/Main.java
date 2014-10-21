
public class Main {

	public static void main(String[] args) {
		Data d1 = new Data(2008, 8, 11);
		Data d2 = new Data(1973, 1, 13);
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d1.precede(d2));
		System.out.println(d1.giorniPassatiDallInizioDellAnno());
		System.out.println(d2.giorniPassatiDallInizioDellAnno());
		System.out.println(d1.giorniPassatiDallInizio());
		System.out.println(d2.giorniPassatiDallInizio());
	}
}