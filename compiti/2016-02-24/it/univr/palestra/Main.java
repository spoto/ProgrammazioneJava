package it.univr.palestra;

public class Main {
	public static void main(String[] args)
			throws IscrizioneSovrappostaException,
				IscrizioneTroppoLungaException,
				IscrizioneVuotaException {

		Registro registro = new Registro();
		Utente u1 = new Utente("Fausto", "Spoto");
		Utente u2 = new Utente("Alan", "Turing");
		Utente u3 = new Utente("Noam", "Chomsky");
		registro.aggiungi(new Iscrizione(u1, Mese.SETTEMBRE, 2014, Mese.GENNAIO, 2015));
		registro.aggiungi(new Iscrizione(u1, Mese.SETTEMBRE, 2015, Mese.FEBBRAIO, 2016));
		registro.aggiungi(new Iscrizione(u1, Mese.MAGGIO, 2016, Mese.LUGLIO, 2016));
		registro.aggiungi(new Iscrizione(u3, Mese.AGOSTO, 2015, Mese.SETTEMBRE, 2015));
		registro.aggiungi(new Iscrizione(u2, Mese.DICEMBRE, 2015, Mese.NOVEMBRE, 2016));
		registro.aggiungi(new Iscrizione(u3, Mese.FEBBRAIO, 2016, Mese.AGOSTO, 2016));
		
		System.out.println(registro);

		Registro registro2015 = registro.proiettaSu(2015);

		System.out.println(registro2015);
	}
}
