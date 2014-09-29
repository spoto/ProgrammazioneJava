
public class Main2 {

	public static void main(String[] args) {
		Semaforo s = new Semaforo();
		s.setCountry(false); // diventa inglese
		s.next(); // diventa arancione
		s.next(); // diventa rosso
		s.next(); // diventa arancione tra rosso e verde
		s.setCountry(true); // torna ad essere italiano

		System.out.println(s.toString());
		s.next();
		System.out.println(s.toString());

		Semaforo s1 = new Semaforo();
		new Semaforo();
		new Semaforo();
		new Semaforo();
		
		System.out.println("finora ho creato "
				+ Semaforo.numeroSemaforiCreatiFinora() + " semafori");
	}
}