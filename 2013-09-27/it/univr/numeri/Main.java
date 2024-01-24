package it.univr.numeri;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		Numero n1 = new NumeroInBaseDue(2034);
		Numero n2 = new NumeroInBaseSedici(2034);
		Numero n3 = new NumeroBCD(2034);

		System.out.println("n1=" + n1);
		System.out.println("n2=" + n2);
		System.out.println("n3=" + n3);

		n2.aggiungi(n3);
		n2.aggiungi(n1);
		n2.sottrai(new NumeroBCD(136));

		System.out.println("n2=" + n2);

		Map<Numero, String> map = new HashMap<Numero, String>();
		map.put(n1, "duemilatrentaquattro in base due");
		map.put(n3, "duemilatrentaquattro in binario a codice decimale");

		// cosa stampa?
		System.out.println(map.get(n1));

		// java.util.TreeSet è un insieme ordinato in
		// senso crescente rispetto a compareTo
		Set<Numero> insieme = new TreeSet<Numero>();
		insieme.add(n1);
		insieme.add(n2);
		insieme.add(n3);
		
		// cosa stampa?
		System.out.println(insieme);
	}
}
