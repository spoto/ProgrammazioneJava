import it.univr.esami.Esame;
import it.univr.esami.Studente;

public class Main {
	public static void main(String[] args) {
		Esame e1 = new Esame("Programmazione I", 28);
		Esame e2 = new Esame("Algoritmi", 26);
		Studente s1 = new Studente("Camillo");
		s1.registra(e1);
		s1.registra(e2);

		s1.getEsami()[2] = new Esame("Truffa", 30);
		
		System.out.println(s1.toString());
		System.out.println(s1.getMediaVoti());
	}
}
