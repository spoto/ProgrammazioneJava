
public class Main {

	public static void main(String[] args) {
		Felino f1 = new Felino("felix");
		Felino f2 = new Felino("fuffi");
		Gatto g = new Gatto("ciccio");
		Tigre t = new Tigre("attila");
		GattoScozzese gs = new GattoScozzese("Queen");

		presenta(f1);
		presenta(f2);
		presenta(g);
		presenta(t);
		presenta(gs);
	}

	private static void presenta(Felino felino) {
		System.out.println("*********************");
		System.out.println(felino.toString());
		System.out.println("costo: " + felino.costo() + " euro");
		System.out.println("domestico: " + felino.domestico());
	}
}
