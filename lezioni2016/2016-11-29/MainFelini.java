import java.util.Scanner;


public class MainFelini {
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		System.out.println("gatto/tigre ?");
		String scelta = tastiera.next();
		
		Felino f;

		switch (scelta) {
		case "gatto":
			f = new Gatto("felix"); break;
		case "tigre":
			f = new Tigre("Attila"); break;
		default:
			f = null;
		}
		
		presenta(f);

		tastiera.close();
	}

	private static void presenta(Felino f) {
		if (f != null) {
			System.out.println(f);
			// se è un gatto lo faccio miagolare
			if (f instanceof Gatto)
				((Gatto) f).miagola();
		}
	}
}
