package it.univr.palestra;

public class Iscrizione implements Comparable<Iscrizione> {
	private final Utente utente;
	private final Mese meseInizio;
	private final int annoInizio;
	private final Mese meseFine;
	private final int annoFine;
	
	public Iscrizione(Utente utente, Mese meseInizio, int annoInizio, Mese meseFine, int annoFine)
			throws IscrizioneTroppoLungaException, IscrizioneVuotaException {

		this.utente = utente;
		this.meseInizio = meseInizio;
		this.annoInizio = annoInizio;
		this.meseFine = meseFine;
		this.annoFine = annoFine;

		if (annoInizio > annoFine || (annoInizio == annoFine && meseInizio.compareTo(meseFine) > 0))
			throw new IscrizioneVuotaException();
		if (annoInizio + 1 < annoFine || (annoInizio + 1 == annoFine && meseInizio.compareTo(meseFine) <= 0))
			throw new IscrizioneTroppoLungaException();
	}

	public Utente getUtente() {
		return utente;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Iscrizione) {
			Iscrizione otherAsIscrizione = (Iscrizione) other;
			return utente.equals(otherAsIscrizione.utente) &&
				meseInizio == otherAsIscrizione.meseInizio &&
				annoInizio == otherAsIscrizione.annoInizio &&
				meseFine == otherAsIscrizione.meseFine &&
				annoFine == otherAsIscrizione.annoFine;
		}
		else
			return false;
	}

	@Override
	public int hashCode() {
		return utente.hashCode() ^ meseInizio.hashCode() ^ annoInizio ^ meseFine.hashCode() ^ annoFine;
	}

	@Override
	public int compareTo(Iscrizione other) {
		int diff = annoInizio - other.annoInizio;
		if (diff != 0)
			return diff;
		diff = meseInizio.compareTo(other.meseInizio);
		if (diff != 0)
			return diff;
		diff = utente.compareTo(other.utente);
		if (diff != 0)
			return diff;
		diff = annoFine - other.annoFine;
		if (diff != 0)
			return diff;
		else
			return meseFine.compareTo(other.meseFine);
	}

	@Override
	public String toString() {
		return utente + ": dall'inizio di " + meseInizio + " " + annoInizio
			+ " alla fine di " + meseFine + " " + annoFine;
	}

	public boolean sovrappostaCon(Iscrizione other) {
		return contiene(other.meseInizio, other.annoInizio) ||
			other.contiene(meseInizio, annoInizio);
	}

	private boolean contiene(Mese mese, int anno) {
		return minoreOUguale(meseInizio, annoInizio, mese, anno)
			&& minoreOUguale(mese, anno, meseFine, annoFine);
	}

	private static boolean minoreOUguale(Mese mese1, int anno1, Mese mese2, int anno2) {
		return anno1 < anno2 || (anno1 == anno2 && mese1.compareTo(mese2) <= 0);
	}

	public int costo() {
		int mesi;
		
		if (annoInizio == annoFine)
			mesi = meseFine.ordinal() - meseInizio.ordinal() + 1;
		else
			mesi = 13 - (meseInizio.ordinal() - meseFine.ordinal());

		switch (mesi) {
		case 1: case 2:
			return 50 * mesi;
		case 3: case 4: case 5:
			return 40 * mesi;
		case 12:
			return 30 * mesi;
		default:
			return 35 * mesi;
		}
	}
	
	public boolean relativaAl(int anno) {
		return anno == annoInizio || anno == annoFine;
	}
}