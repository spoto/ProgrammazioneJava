
public class MainFelini {
	public static void main(String[] args) {
		Felino f1 = new Felino();
		Felino f2 = new Felino();
		Felino g1 = new Gatto("felix");
		Felino t1 = new Tigre("Attila");
		Felino p1 = new GattoPersiano("Gigi");
		Felino s1 = new GattoScozzese("Intosh");
		Object o = new Object();
		System.out.println(o);
		System.out.println(f1);
		
		System.out.println(f1 + ": " + f1.possoComprarloCon(50));
		System.out.println(f2 + ": " + f2.possoComprarloCon(50));
		System.out.println(g1 + ": " + g1.possoComprarloCon(50));
		System.out.println(t1 + ": " + t1.possoComprarloCon(50));
		System.out.println(p1 + ": " + p1.possoComprarloCon(50));
		System.out.println(s1 + ": " + s1.possoComprarloCon(50));
	}
}
