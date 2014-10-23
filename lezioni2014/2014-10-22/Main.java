
public class Main {

	public static void main(String[] args) {
		Semaforo s1 = new Semaforo();
		Semaforo s2 = new Semaforo();
		s2.rosso();
		System.out.println("Questo è s1:\n" + s1);
		System.out.println("Questo è s2:\n" + s2);

		Semaforo.diventaInglese();
		for (int count = 0; count < 10; count++) {
			s1.prossimo();
			System.out.println();
			System.out.println(s1);
		}
	}
}