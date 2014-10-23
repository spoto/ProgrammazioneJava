
public class Test {

	public static void main(String[] args) {
		// un semaforo italiano dopo l'arancione ha il rosso
		Semaforo s = new Semaforo();
		Semaforo.diventaInglese();
		s.prossimo();
		s.prossimo();
		s.prossimo();
		Semaforo.diventaItaliano();
		s.prossimo();
		System.out.println(s); // BUG?
	}
}