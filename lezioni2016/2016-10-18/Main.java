
public class Main {

	public static void main(String[] args) {
		Hour h = new Hour(12, 59);  // creato e inizializzato
		h.tick();
		String s = h.toString();
		System.out.println(s);		
	}
}
