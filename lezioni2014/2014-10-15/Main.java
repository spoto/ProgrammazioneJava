
public class Main {

	public static void main(String[] args) {
		Orario o1 = new Orario(8, 42, 10);
		
		int p = 5;
		o1.stampa();
		System.out.println("p = " + p);
		o1.aggiungi(2);
		o1.aggiungi(p, 20);
		o1.stampa();
		System.out.println("p = " + p);
	}
}