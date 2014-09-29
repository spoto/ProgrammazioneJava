import it.univr.numeri.Binario;
import it.univr.numeri.Decimale;
import it.univr.numeri.Esadecimale;
import it.univr.numeri.Numero;
import it.univr.numeri.Romano;


public class Main {
	public static void main(String[] args) {
		Numero n1 = new Decimale(134);
		Numero n2 = new Binario(120);
		Numero n3 = new Esadecimale(13470);
		Numero n4 = new Romano(340);

		System.out.println(n1);
		System.out.println(n2);
		System.out.println(n3);
		System.out.println(n4);

		n3.add(n2);
		System.out.println(n3);
		n4.add(n2);
	}
}
