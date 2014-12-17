package it.univr.plot;

import java.util.ArrayList;
import java.util.Iterator;

public class ProvaIterabile {

	public static void main(String[] args) {
		ArrayList<String> l = new ArrayList<String>();
		l.add("ciao");
		l.add("come va?");
		l.add("questa è una stringa");
		l.add("fine!");

		Iterator<String> it = l.iterator();
		while (it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}

		// zucchero sintattico equivalente alle 5 righe sopra
		for (String s: l)
			System.out.println(s);
	}
}
