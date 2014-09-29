import static org.junit.Assert.*;
import org.junit.Test;

public class SemaforoTest {

	@Test
	public void testNasceVerdeItaliano() {
		Semaforo s = new Semaforo();

		assertTrue(s.verde() && s.italiano());
	}

	@Test
	public void testCostruttoreGenerico() {
		Semaforo s = new Semaforo(1, false);

		assertTrue(s.arancione() && s.inglese());
	}

	@Test
	public void testNext() {
		Semaforo s = new Semaforo(1, false);
		s.next();

		assertTrue(s.rosso() && s.inglese());
	}

	@Test
	public void testCambioNazionalita() {
		Semaforo s = new Semaforo();
		s.setCountry(false); // diventa inglese
		s.next(); // diventa arancione
		s.next(); // diventa rosso
		s.next(); // diventa arancione tra rosso e verde
		s.setCountry(true); // torna ad essere italiano
		s.next();

		assertTrue(s.rosso() && s.italiano());
	}
}