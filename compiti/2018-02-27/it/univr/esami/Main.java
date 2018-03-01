package it.univr.esami;

public class Main {
	public static void main(String[] args) throws VerbalizzazioneGiàEffettuataException, StudenteNonIscrittoException {
		Esame esame = new EsamePerEsito();
		Studente s1 = new Studente(151535, "Giorgio", "Levi");
		Studente s2 = new Studente(200345, "Fausto", "Spoto");
		Studente s3 = new Studente(324422, "Albert", "Einstein");
		Studente s4 = new Studente(145066, "Camilla", "De Sanctis");
		Studente s5 = new Studente(111044, "Eleonora", "Botticelli");

		esame.iscrivi(s1, s2, s4, s5);
		esame.verbalizza(s1, Esito.VENTI);
		esame.verbalizza(s4, Esito.TRENTAELODE);
		esame.verbalizza(s2, Esito.RITIRATO);
		esame.verbalizza(s5, Esito.VENTI);
		
		System.out.println(esame);
		
		esame.verbalizza(s3, Esito.TRENTA);
	}
}