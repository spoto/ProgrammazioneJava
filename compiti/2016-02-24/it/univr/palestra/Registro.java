package it.univr.palestra;

import java.util.SortedSet;
import java.util.TreeSet;

public class Registro {
	private final SortedSet<Iscrizione> iscrizioni = new TreeSet<>();
	
	public void aggiungi(Iscrizione iscrizione) throws IscrizioneSovrappostaException {
		Utente utente = iscrizione.getUtente();

		for (Iscrizione altra: iscrizioni)
			if (altra.getUtente().equals(utente) && altra.sovrappostaCon(iscrizione))
				throw new IscrizioneSovrappostaException();

		iscrizioni.add(iscrizione);
	}

	@Override
	public String toString() {
		String res = "";
		for (Iscrizione iscrizione: iscrizioni)
			res += iscrizione + ": " + iscrizione.costo() + " euro\n";

		return res;
	}

	public Registro proiettaSu(int anno) {
		Registro risultato = new Registro();
		for (Iscrizione iscrizione: iscrizioni)
			if (iscrizione.relativaAl(anno))
				risultato.iscrizioni.add(iscrizione);

		return risultato;
	}
}